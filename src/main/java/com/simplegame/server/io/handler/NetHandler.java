package com.simplegame.server.io.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.simplegame.core.utils.Md5Utils;
import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.io.global.ChannelThresholdChecker;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月5日 下午7:10:58
 * 
 */
@Sharable
@Component
public class NetHandler extends SimpleChannelInboundHandler<Object> {

	private Logger LOG = LoggerFactory.getLogger(getClass());

	@Resource
	private ChannelThresholdChecker channelChecker;

	@Resource
	private ChannelManager channelManager;

	private AtomicLong next = new AtomicLong();
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
		String ip = address.getHostName();

		if (channelChecker.isFull()) {
			ctx.close();

			LOG.trace("network connect is full. count: {}", channelManager.getSessionCount());
			return;
		}

		if (channelChecker.isBlackIp(ip)) {
			ctx.close();

			LOG.error("blacklist limit. ip: {}", ip);
			return;
		}
		
		/**
		 * netty 4.1+ use channel.id()
		 * 
		 * current netty version: 4.0.27
		 */
		addSessionId(ctx.channel());
	}
	
	private String addSessionId(Channel ch) {
		String localAddress  = ch.localAddress().toString();
		String remoteAddress = ch.remoteAddress().toString();
		long now = System.nanoTime();
		
		String sessionId = Md5Utils.md5To32(localAddress + remoteAddress + now + next.incrementAndGet()); 
		AttributeKey<String> sessionKey = AttributeKey.valueOf(IoConstants.SESSION_KEY);
		
		ch.attr(sessionKey).set(sessionId);
		
		LOG.info("channel active sessionId: {}", sessionId);
		
		return sessionId;
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String roleId = attr(ctx.channel(), IoConstants.ROLE_KEY);

		if (null != roleId) {
			channelManager.removeChannel(roleId);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		LOG.debug("server receive message: {}", JSONObject.toJSONString(msg));

		channelManager.addChannel(attr(ctx.channel(), IoConstants.SESSION_KEY), ctx.channel());
		
	}
	
	@SuppressWarnings("unchecked")
	private String attr(Channel channel, String... params) {
		if( params.length == 0 ) {
			return null;
		}
		
		AttributeKey key = AttributeKey.valueOf(params[0]);
		
		if( params.length == 1 ) {
			return (String)channel.attr(key).get();
		} else {
			channel.attr(key).set(params[1]);
			return params[1]; 
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		AttributeKey<String> key = AttributeKey.valueOf(IoConstants.ROLE_KEY);
		String roleId = ctx.channel().attr(key).get();

		if (null != roleId) {
			LOG.info("{} disconnect.", key);
		}
	}

}
