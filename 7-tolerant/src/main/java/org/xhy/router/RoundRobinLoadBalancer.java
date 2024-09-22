package org.xhy.router;

import org.xhy.common.URL;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 00:19
 */
public class RoundRobinLoadBalancer implements LoadBalancer{

    private static AtomicInteger roundRobinId = new AtomicInteger(0);


    @Override
    public URL select(List<URL> urls) {

        roundRobinId.addAndGet(1);
        if (roundRobinId.get() == Integer.MAX_VALUE){
            roundRobinId.set(0);
        }
        return urls.get(roundRobinId.get() % urls.size());
    }
}
