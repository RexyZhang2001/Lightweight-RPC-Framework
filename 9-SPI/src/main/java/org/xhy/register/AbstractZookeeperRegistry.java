package org.xhy.register;

import org.xhy.common.Cache;
import org.xhy.common.ServiceName;
import org.xhy.common.URL;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-15 00:50
 */
public abstract class AbstractZookeeperRegistry implements RegistryService{



    @Override
    public void register(URL url) throws Exception {
        final ServiceName serviceName = new ServiceName(url.getServiceName(), url.getVersion());
        if (!Cache.SERVICE_URLS.containsKey(serviceName)) {
            Cache.SERVICE_URLS.put(serviceName,new ArrayList<>());
        }
        Cache.SERVICE_URLS.get(serviceName).add(url);
    }

    @Override
    public void unRegister(URL url) throws Exception {
        final ServiceName serviceName = new ServiceName(url.getServiceName(), url.getVersion());
        if (Cache.SERVICE_URLS.containsKey(serviceName)){
            Cache.SERVICE_URLS.get(serviceName).remove(url);
        }
    }

    @Override
    public List<URL> discoveries(String serviceName, String version) throws Exception {
        final ServiceName key = new ServiceName(serviceName, version);
        List<URL> urls = Cache.SERVICE_URLS.get(key);
        return urls;
    }

}
