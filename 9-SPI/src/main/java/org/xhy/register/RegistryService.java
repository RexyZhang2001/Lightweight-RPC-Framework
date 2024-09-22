package org.xhy.register;

import org.xhy.common.Host;
import org.xhy.common.URL;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 21:12
 */
public interface RegistryService {

    void register(URL url) throws Exception;

    void unRegister(URL url) throws Exception;

    List<URL> discoveries(String serviceName, String version) throws Exception;

    void subscribe(URL url) throws Exception;

    void unSubscribe(URL url);

}
