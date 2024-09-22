package org.xhy.utils;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 21:24
 */
public class ServiceNameBuilder {
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("$", serviceName, serviceVersion);
    }

    public static String buildServiceNodeInfo(String key,String ip,Integer port){
        return String.join("#", key, ip,String.valueOf(port));
    }
}
