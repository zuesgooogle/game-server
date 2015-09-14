package com.simplegame.server.public_.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.message.Message;
import com.simplegame.core.message.Message.DestType;
import com.simplegame.core.message.Message.FromType;
import com.simplegame.server.message.IMsgDispatcher;
import com.simplegame.server.message.manager.SwapManager;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月9日 下午5:46:50
 * 
 */
@Component
public class PublicMsgSender {

    @Resource
    private IMsgDispatcher publicDispatcher;

    @Resource
    private SwapManager swapManager;

    public void send2OneBySessionId(String command, String userId, String sessionId, Object data) {
        //Object[] message = new Object[] { command, data, DestType.CLIENT.getValue(), FromType.BUS.getValue(), 1, sessionId, null, userId, 0, null };

        Message message = new Message(command, data, FromType.BUS, DestType.CLIENT, userId, sessionId);
        
        swapManager.swap(message);
    }

//    public void send2One(String command, String userId, Object data) {
//        Object[] message = new Object[] { command, data, DestType.CLIENT.getValue(), FromType.BUS.getValue(), 1, null, null, userId, 0, null };
//
//        publicDispatcher.in(message);
//    }

    public void send2PublicInner(String command, String roleId, Object data) {
        //Object[] message = new Object[] { command, data, DestType.STAGE_CONTROL.getValue(), FromType.BUS.getValue(), 1, null, null, userId, 0, null };
        
        Message message = new Message(command, data, FromType.BUS, DestType.STAGE_CONTROL, roleId);
        
        publicDispatcher.in(message);
    }
}
