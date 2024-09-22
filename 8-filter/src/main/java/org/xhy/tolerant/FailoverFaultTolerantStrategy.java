package org.xhy.tolerant;

import io.netty.channel.ChannelFuture;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import org.xhy.common.*;
import org.xhy.socket.codec.RpcResponse;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description: 故障转移
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 23:24
 */
public class FailoverFaultTolerantStrategy implements FaultTolerantStrategy{

    @Override
    public Object handler(FaultContext faultContext) throws Exception {
        final URL currentURL = faultContext.getCurrentURL();
        final List<URL> urls = faultContext.getUrls();
        final Iterator<URL> iterator = urls.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(currentURL)) {
                iterator.remove();
            }
        }
        if (urls.isEmpty()) {
            throw new Exception("服务端发生异常,触发故障容错机制: 故障转移,无服务可用");
        }
        final URL url = urls.get(0);
        final ChannelFuture channelFuture = Cache.CHANNEL_FUTURE_MAP.get(new Host(url.getIp(),url.getPort()));

        channelFuture.channel().writeAndFlush(faultContext.getRpcProtocol());
        RpcFuture<RpcResponse> future = new RpcFuture(new DefaultPromise(new DefaultEventLoop()), 3000);
        RpcRequestHolder.REQUEST_MAP.put(faultContext.getRequestId(), future);
        RpcResponse rpcResponse = future.getPromise().sync().get(future.getTimeout(), TimeUnit.MILLISECONDS);
        if (rpcResponse.getException()!=null){
            faultContext.setCurrentURL(url);
            return handler(faultContext);
        }
        return rpcResponse.getData();
    }
}
