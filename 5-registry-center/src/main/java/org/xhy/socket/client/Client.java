package org.xhy.socket.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhy.common.*;
import org.xhy.common.constants.*;
import org.xhy.event.RpcListerLoader;
import org.xhy.proxy.IProxy;
import org.xhy.proxy.ProxyFactory;
import org.xhy.register.RegistryFactory;
import org.xhy.register.RegistryService;
import org.xhy.service.HelloService;
import org.xhy.socket.codec.*;

import java.util.List;

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

    private  Bootstrap bootstrap;
    private  EventLoopGroup eventLoopGroup;

    private ChannelFuture channelFuture;

    public Client(String host, Integer port) {
        this.host = host;
        this.port = port;

    }
    public void run(){
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

        Cache.BOOT_STRAP = bootstrap;
    }


    public void connectServer() throws Exception {
        for(URL url: Cache.SUBSCRIBE_SERVICE_LIST){
            final RegistryService registryService = RegistryFactory.get(Register.ZOOKEEPER);
            final List<URL> urls = registryService.discoveries(url.getServiceName(), url.getVersion());
            for (URL u : urls) {
                final ChannelFuture connect = bootstrap.connect(u.getIp(), u.getPort());
                Cache.CHANNEL_FUTURE_MAP.put(new Host(u.getIp(),u.getPort()),connect);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new RpcListerLoader().init();
        final Client client = new Client("127.0.0.1", 8081);
        client.run();
        final RegistryService registryService = RegistryFactory.get(Register.ZOOKEEPER);
        final URL url = new URL();
        url.setServiceName(HelloService.class.getName());
        url.setVersion("1.0");
        registryService.subscribe(url);
        client.connectServer();
        final IProxy iproxy = ProxyFactory.get(RpcProxy.CG_LIB);
        final HelloService proxy = iproxy.getProxy(HelloService.class);
        System.out.println(proxy.hello("xixi ~ "));
    }

}
