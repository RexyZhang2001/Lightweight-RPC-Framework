package org.xhy.event;

import io.netty.channel.ChannelFuture;
import org.xhy.common.Cache;
import org.xhy.common.Host;
import org.xhy.common.ServiceName;
import org.xhy.common.URL;

import java.util.ArrayList;


/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-14 23:45
 */
public class AddRpcLister implements IRpcLister<AddRpcEventData>{

    @Override
    public void exec(AddRpcEventData addRpcLister) {
        final URL url = (URL) addRpcLister.getData();
        final ServiceName serviceName = new ServiceName(url.getServiceName(), url.getVersion());
        if (!Cache.SERVICE_URLS.containsKey(serviceName)){
            Cache.SERVICE_URLS.put(serviceName,new ArrayList<>());
        }
        Cache.SERVICE_URLS.get(serviceName).add(url);
        final Host ip = new Host(url.getIp(), url.getPort());
        if (!Cache.CHANNEL_FUTURE_MAP.containsKey(ip)) {
            ChannelFuture channelFuture = Cache.BOOT_STRAP.connect(url.getIp(),url.getPort());
            Cache.CHANNEL_FUTURE_MAP.put(ip,channelFuture);
        }
    }
}
