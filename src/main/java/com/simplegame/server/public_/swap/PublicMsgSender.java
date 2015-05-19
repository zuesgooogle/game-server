package com.simplegame.server.public_.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.message.manager.SwapManager;
import com.simplegame.server.share.moduleinit.CommandGroup;

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
		Object[] message = new Object[]{command, data, CommandGroup.DEST_TYPE_CLIENT, CommandGroup.FROM_TYPE_BUS, 1, sessionId, null, userId, 0, null};
		
		swapManager.swap(message);
	}
}
