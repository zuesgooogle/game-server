package com.simplegame.server.io.action;

import io.netty.channel.Channel;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.proto.Message.Response;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.io.message.IoMessage;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月19日 下午5:02:38
 *
 */
@ActionWorker
public class IoMsgOutAction {

	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ChannelManager channelManager;
	
	@ActionMapping(mapping = IoMessage.IO_MSG_OUT_CMD)
	public void out(IoMessage message) {
		LOG.info("message out: {}" + message.toString());
		
		String sessionId = message.getSessionId();
		
		
		Channel channel = channelManager.getChannel(sessionId);
		
		Response.Builder builder = Response.newBuilder();
		builder.setCommand( (String)(message.getMsgSource()[0]) )
			   .setData( message.toString() );
		
		channel.writeAndFlush(builder);
	}
	
}
