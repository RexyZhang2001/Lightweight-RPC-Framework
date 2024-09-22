package org.xhy.utils;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-15 11:09
 */
public class IPBuilder {

    private static final String symbol = ":";
    public static String buildIp(String host,Integer port){
        return host + symbol + port;
    }
}
