package com.example.demo.test.testnetty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName: NettyChatClientHandler
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/1/25 15:24
 * @Version: 1.0
 */
public class NettyChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
