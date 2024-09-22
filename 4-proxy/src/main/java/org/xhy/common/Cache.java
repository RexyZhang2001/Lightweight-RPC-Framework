package org.xhy.common;

import io.netty.channel.ChannelFuture;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:49
 */
public class Cache {

    public static Map<ServiceName,URL> services = new HashMap<ServiceName, URL>();

    public static Map<URL, ChannelFuture> channelFutureMap = new HashMap<URL, ChannelFuture>();
}
