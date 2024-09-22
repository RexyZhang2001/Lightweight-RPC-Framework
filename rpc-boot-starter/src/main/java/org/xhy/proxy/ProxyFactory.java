package org.xhy.proxy;

import org.xhy.common.constants.RpcProxy;
import org.xhy.proxy.cglib.CgLibProxyFactory;
import org.xhy.spi.ExtensionLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:26
 */
public class ProxyFactory {



    public static IProxy get(RpcProxy rpcProxy){
        return ExtensionLoader.getInstance().get(rpcProxy.name);

    }

    public static IProxy get(String name){
        return ExtensionLoader.getInstance().get(name);

    }

    public static void init() throws IOException, ClassNotFoundException {
        ExtensionLoader.getInstance().loadExtension(IProxy.class);
    }
}
