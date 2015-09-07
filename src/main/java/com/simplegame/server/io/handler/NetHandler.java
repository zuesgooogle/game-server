package com.simplegame.server.io.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;
import com.simplegame.protocol.proto.Message.Request;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.io.IoConstants;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.io.swap.IoMsgSender;
import com.simplegame.server.login.commond.LoginCommands;
import com.simplegame.server.public_.nodecontrol.command.NodeControlCommands;
import com.simplegame.server.utils.ChannelAttributeUtil;

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

	@Resource
	private IoMsgSender msgSender;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String roleId = ChannelAttributeUtil.attr(ctx.channel(), IoConstants.ROLE_KEY);

		if (null != roleId) {
			channelManager.removeChannel(roleId);
			
			exitNotify(ctx);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Request msg) throws Exception {
		LOG.info("server receive message: {}", msg.toString());

		JSONArray array = JSONArray.parseArray(msg.getData());
		if( null == array ) {
		    array = new JSONArray();
		}
		
		String sessionId = ChannelAttributeUtil.attr(ctx.channel(), IoConstants.SESSION_KEY);
		String command = msg.getCommand();
		
		switch(command) {
		case LoginCommands.IN:
		    channelManager.addChannel(sessionId, ctx.channel());
		    
		    break;
		case StageControllCommands.LOGIN:
		    command = NodeControlCommands.ROLE_IN;
            
            String roleId = array.getString(0);
            ChannelAttributeUtil.attr(ctx.channel(), IoConstants.ROLE_KEY, roleId);
            
            channelManager.addChannel(roleId, ctx.channel());
		    break;
		}
		
		String roleId = ChannelAttributeUtil.attr(ctx.channel(), IoConstants.ROLE_KEY);
		String ip = ChannelAttributeUtil.attr(ctx.channel(), IoConstants.IP_KEY);
		
		Object[] message = new Object[]{command, array.toArray(), DestType.BUS.getValue(), FromType.CLIENT.getValue(), null, sessionId, roleId, null, null, null, ip};
		msgSender.swap(message);
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		AttributeKey<String> key = AttributeKey.valueOf(IoConstants.ROLE_KEY);
		String roleId = ctx.channel().attr(key).get();

		if (null != roleId) {
			LOG.info("{} disconnect.", roleId);
		}
		
		cause.printStackTrace();
	}

	/**
	 * 退出服务
	 * 
	 * @param ctx
	 * @throws Exception
	 */
	private void exitNotify(ChannelHandlerContext ctx) throws Exception {
	    Request.Builder exit = Request.newBuilder();
	    exit.setCommand(NodeControlCommands.ROLE_OUT)
	        .setData("[]");
	
	    channelRead0(ctx, exit.build());
	}
}
