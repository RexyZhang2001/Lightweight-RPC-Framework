package org.xhy.invoke;

import org.xhy.common.constants.RpcInvoker;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 16:59
 */
public class InvokerFactory {

    public static Map<RpcInvoker,Invoker> invokerInvokerMap = new HashMap();

    static {
        invokerInvokerMap.put(RpcInvoker.JDK,new JdkReflectionInvoker());
    }

    public static Invoker get(RpcInvoker rpcInvoker){
        return invokerInvokerMap.get(rpcInvoker);
    }
}
