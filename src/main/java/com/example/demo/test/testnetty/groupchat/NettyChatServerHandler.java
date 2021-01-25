package com.example.demo.test.testnetty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName: NettyChatServerHandler
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/1/25 10:33
 * @Version: 1.0
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端活跃通知
        System.out.println(ctx.channel().remoteAddress() + "is on lineing ..............");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //客户端失去活跃通知
        System.out.println(ctx.channel().remoteAddress() + "outline ...........");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常
        System.out.println(cause.getMessage());
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //客户端连接检测
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "is on line..");
        channelGroup.writeAndFlush(channel.remoteAddress()+" is on line...");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //客户端离线检测
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "is out line...");
        channelGroup.remove(channel);
        channelGroup.writeAndFlush(channel.remoteAddress()+" is out line...");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " : " + msg);
        channelGroup.writeAndFlush(channel.remoteAddress() + " say: " + msg);
    }
}
