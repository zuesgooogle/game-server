package com.simplegame.server.io.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplegame.protocol.message.Message;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月5日 下午7:10:58
 *
 */

public class NetHandler extends SimpleChannelInboundHandler<Message> {

	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		
	}

}
