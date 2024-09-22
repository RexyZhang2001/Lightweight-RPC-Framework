package org.xhy.socket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.xhy.socket.codec.RpcProtocol;

public class SimpleChatServerHandler extends SimpleChannelInboundHandler<RpcProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcRequestRpcProtocol) throws Exception {
        System.out.println(rpcRequestRpcProtocol.getBody());
    }
}