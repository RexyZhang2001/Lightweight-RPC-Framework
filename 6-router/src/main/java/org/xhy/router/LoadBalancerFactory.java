package org.xhy.router;

import org.xhy.common.constants.LoadBalance;
import org.xhy.register.RegistryService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 00:18
 */
public class LoadBalancerFactory {

    private static Map<LoadBalance, LoadBalancer> loadBalancerMap = new HashMap();

    static {
        loadBalancerMap.put(LoadBalance.Round,new RoundRobinLoadBalancer());
    }


    public static LoadBalancer get(LoadBalance loadBalance){
        return loadBalancerMap.get(loadBalance);
    }
}

