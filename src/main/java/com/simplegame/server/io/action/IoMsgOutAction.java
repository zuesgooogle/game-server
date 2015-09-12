package com.simplegame.server.io.action;

import io.netty.channel.Channel;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.proto.Message.Response;
import com.simplegame.server.io.global.ChannelManager;
import com.simplegame.server.io.message.IoMessage;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月19日 下午5:02:38
 * 
 */
@ActionWorker
public class IoMsgOutAction {

    private Logger LOG = LogManager.getLogger(getClass());

    @Resource
    private ChannelManager channelManager;

    @ActionMapping(mapping = IoMessage.IO_MSG_OUT_CMD)
    public void out(IoMessage message) {
        LOG.info("message out: {}", message.toString());

        Response.Builder builder = Response.newBuilder();
        builder.setCommand(message.getRealCommand()).setData(message.toData());

        int route = message.getRoute();
        switch (route) {
        case 1: // one player
            Channel channel = null;
            String sessionId = message.getSessionId();
            if (null != sessionId) {
                channel = channelManager.getChannel(sessionId);
            }

            String roleId = message.getRoleId();
            if (null != roleId) {
                channel = channelManager.getChannel(roleId);
            }

            if (null != channel) {
                channel.writeAndFlush(builder);
            }

            break;
        case 2: // mutile player
            break;
        case 3: // all player
            break;
        }

    }

}
