package com.simplegame.server.io.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.core.utils.Md5Utils;
import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月11日 下午10:03:22 
 *
 */
@Sharable
@Component
public class ConnectCheckHandler extends ChannelInboundHandlerAdapter {

	private Logger LOG = LoggerFactory.getLogger(getClass());

	@Resource
	private ChannelManager channelManager;

	private AtomicLong next = new AtomicLong();
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
		String ip = address.getHostName();

		if (channelManager.isFull()) {
			ctx.close();

			LOG.trace("network connect is full. count: {}", channelManager.getSessionCount());
			return;
		}

		if (channelManager.isBlackIp(ip)) {
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
}
