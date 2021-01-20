package com.example.demo.test.testnetty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName: NettyServer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/1/20 9:58
 * @Version: 1.0
 */
public class NettyServer {

    public static void main(String[] args) {
        //创建事件监听循环组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //读写事件监听循环组
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //创建服务端启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel作为服务器通道的实现
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列的连接数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//设置workGroup保持活连接状态
                    //handler(null) // 该 handler对应 bossGroup , childHandler 对应 workerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("...Server is ready...");
            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(6669).sync();
            //对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
