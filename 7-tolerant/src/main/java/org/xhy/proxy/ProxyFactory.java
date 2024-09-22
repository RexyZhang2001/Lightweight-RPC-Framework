package org.xhy.proxy;

import org.xhy.common.constants.RpcProxy;
import org.xhy.proxy.cglib.CgLibProxyFactory;

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

    private static Map<RpcProxy,IProxy> proxyIProxyMap = new HashMap<RpcProxy, IProxy>();

    static {
        proxyIProxyMap.put(RpcProxy.CG_LIB,new CgLibProxyFactory());
    }

    public static IProxy get(RpcProxy rpcProxy){
        return proxyIProxyMap.get(rpcProxy);
    }
}
