package org.xhy.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-14 23:43
 */
public class RpcListerLoader {

    private static ExecutorService eventThreadPool = Executors.newFixedThreadPool(2);


    private static List<IRpcLister> rpcListerList = new ArrayList<>();

    public void init(){
        registerLister(new AddRpcLister());
        registerLister(new DestroyRpcLister());
        registerLister(new UpdateRpcLister());
    }
    public static void registerLister(IRpcLister rpcLister){
        rpcListerList.add(rpcLister);
    }

    public static void sendEvent(RpcEventData eventData){
        if (eventData == null){
            return;
        }
        if (!rpcListerList.isEmpty()){
            for (IRpcLister iRpcLister : rpcListerList) {
                // 获取接口上的泛型
                final Class<?> generics = getInterfaceGenerics(iRpcLister);
                if (eventData.getClass().equals(generics)){
                    eventThreadPool.execute(()->{
                        iRpcLister.exec(eventData);
                    });
                }
            }
        }

    }

    public static Class<?> getInterfaceGenerics(Object o) {
        Type[] types = o.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) types[0];
        Type type = parameterizedType.getActualTypeArguments()[0];
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        }
        return null;
    }
}
