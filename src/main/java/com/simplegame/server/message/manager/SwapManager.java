package com.simplegame.server.message.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.message.IMsgDispatcher;
import com.simplegame.server.message.MsgUtil;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月10日 下午8:41:22 
 *
 */
@Component
public class SwapManager {

	@Resource
	private IMsgDispatcher ioDispatcher;
	
	@Resource
	private IMsgDispatcher publicDispatcher;
	
	public void swap(Object[] message) {
		int fromType = MsgUtil.getFromType(message);
		switch(fromType) {
		case CommandGroup.FROM_TYPE_CLIENT:
			swapClientMsg(message);
			break;
		case CommandGroup.FROM_TYPE_BUS:
			break;
		case CommandGroup.FROM_TYPE_STAGE:
			break;
		}
	}
	
	public void swapClientMsg(Object[] message) {
		String command = MsgUtil.getCommand(message);
		int group = CommandGroup.getCmdDest(command);
		
		//dest type to group
		message[2] = Integer.valueOf(group);
		
		switch(group) {
		case 1:
		case 4:
			toPublic(message);
			break;
		}
	}
	
	private void swapPublicMsg(Object message) {
		
	}
	
	
	private void toPublic(Object message) {
		publicDispatcher.in(message);
	}
}
