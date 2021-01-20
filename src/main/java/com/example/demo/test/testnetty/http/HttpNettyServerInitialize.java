package com.example.demo.test.testnetty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author 作者 lqq
 * @ClassName 类名 HttpNettyServerInitialize
 * @date 2021/1/20 21:13
 * @注释：
 */
public class HttpNettyServerInitialize extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        pipeline.addLast("MyHttpNettyServerHandler",new HttpNettyServerHandler());
        System.out.println("ok~~~~");
    }
}
