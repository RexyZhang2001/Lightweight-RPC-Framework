package org.xhy.socket.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhy.common.*;
import org.xhy.common.constants.RpcProxy;
import org.xhy.proxy.IProxy;
import org.xhy.proxy.ProxyFactory;
import org.xhy.service.HelloService;
import org.xhy.socket.codec.*;
import org.xhy.common.constants.MsgType;
import org.xhy.common.constants.ProtocolConstants;
import org.xhy.common.constants.RpcSerialization;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-07 12:09
 */
public class Client {
    private Logger logger = LoggerFactory.getLogger(Client.class);

    private final String host;

    private final Integer port;

    private final Bootstrap bootstrap;
    private final EventLoopGroup eventLoopGroup;

    private ChannelFuture channelFuture;

    public Client(String host, Integer port) throws InterruptedException {
        this.host = host;
        this.port = port;

        bootstrap = new Bootstrap();
        eventLoopGroup = new NioEventLoopGroup(4);
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new RpcEncoder())
                                .addLast(new RpcDecoder())
                                .addLast(new ClientHandler());
                    }
                });

    }

    public void registerBean(String serviceName){
        final URL url = new URL(this.host, port);
        Cache.services.put(new ServiceName(serviceName),url);
        channelFuture = bootstrap.connect(host,port);
        Cache.channelFutureMap.put(url,channelFuture);
    }

    public static void main(String[] args) throws Exception {
        final Client client = new Client("127.0.0.1", 8081);
        client.registerBean(HelloService.class.getName());
        final IProxy iproxy = ProxyFactory.get(RpcProxy.CG_LIB);
        final HelloService proxy = iproxy.getProxy(HelloService.class);
        System.out.println(proxy.hello("xixi"));

    }
}
