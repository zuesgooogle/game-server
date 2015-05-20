package com.simplegame.server.public_.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;
import com.simplegame.server.message.manager.SwapManager;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月9日 下午5:46:50 
 *
 */
@Component
public class PublicMsgSender {

	@Resource
	private SwapManager swapManager;
	
	public void send2OneBySessionId(String command, String userId, String sessionId, Object data) {
		Object[] message = new Object[]{command, data, DestType.CLIENT.getValue(), FromType.BUS.getValue(), 1, sessionId, null, userId, 0, null};
		
		swapManager.swap(message);
	}
	
	public void send2One(String command, String userId, Object data) {
		Object[] message = new Object[]{command, data, DestType.CLIENT.getValue(), FromType.BUS.getValue(), 1, null, null, userId, 0, null};
		
	}
}
