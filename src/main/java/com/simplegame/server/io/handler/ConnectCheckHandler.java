package com.simplegame.server.io.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.utils.ChannelAttributeUtil;

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
		
		String sessionId = UUID.randomUUID().toString().toUpperCase(); 
		
		ChannelAttributeUtil.attr(ctx.channel(), IoConstants.SESSION_KEY, sessionId);
		ChannelAttributeUtil.attr(ctx.channel(), IoConstants.IP_KEY, ip);
		
		
		/**
		 * netty 4.1+ use channel.id()
		 * 
		 * current netty version: 4.0.27
		 */
	}
}
