package com.simplegame.server.io.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.io.global.ChannelThresholdChecker;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月5日 下午7:10:58
 *
 */
@Component
public class NetHandler extends SimpleChannelInboundHandler<Message> {

	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ChannelThresholdChecker channelChecker;
	
	@Resource
	private ChannelManager channelManager;
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
		String ip = address.getHostName();
		
		if( channelChecker.isFull() ) {
			ctx.close();
			
			LOG.trace("network connect is full. count: {}", channelManager.getSessionCount());
			return;
		}
		
		if( channelChecker.isBlackIp(ip) ) {
			ctx.close();
			
			LOG.error("blacklist limit. ip: {}", ip);
			return;
		}
		
	}

	@Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		AttributeKey<String> key = AttributeKey.valueOf(IoConstants.ROLE_KEY);
		String roleId = ctx.channel().attr(key).get();
		
		channelManager.removeChannel(roleId);
	}

	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		LOG.info("server receive message: {}", JSONObject.toJSONString(msg.getData()));
		
	}

}
