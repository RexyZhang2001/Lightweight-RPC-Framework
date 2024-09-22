package org.xhy.invoke;

import org.xhy.common.constants.RpcInvoker;
import org.xhy.spi.ExtensionLoader;

import java.io.IOException;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 16:59
 */
public class InvokerFactory {


    public static Invoker get(RpcInvoker rpcInvoker){
        return ExtensionLoader.getInstance().get(rpcInvoker.name);
    }

    public static Invoker get(String name){
        return ExtensionLoader.getInstance().get(name);
    }

    public static void init() throws IOException, ClassNotFoundException {
        ExtensionLoader.getInstance().loadExtension(Invoker.class);
    }
}
