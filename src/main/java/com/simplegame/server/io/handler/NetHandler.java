package com.simplegame.server.io.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.simplegame.protocol.proto.Message.Request;
import com.simplegame.protocol.proto.Message.Response;
import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月5日 下午7:10:58
 * 
 */
@Sharable
@Component
public class NetHandler extends SimpleChannelInboundHandler<Request> {

	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ChannelManager channelManager;

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String roleId = attr(ctx.channel(), IoConstants.ROLE_KEY);

		if (null != roleId) {
			channelManager.removeChannel(roleId);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Request msg) throws Exception {
		LOG.info("server receive message: {}", msg.toString());

		channelManager.addChannel(attr(ctx.channel(), IoConstants.SESSION_KEY), ctx.channel());
		
		Response.Builder builder = Response.newBuilder();
		builder.setCommand(msg.getCommand())
			   .setData(msg.getData());
		
		ctx.channel().writeAndFlush(builder);
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
