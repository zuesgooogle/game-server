package com.simplegame.server.io.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.message.manager.SwapManager;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午6:11:17
 *
 */
@Component
public class IoMsgSender {

	@Resource
	private IoMsgDispatcher ioDispatcher;
	
	@Resource
	private SwapManager swapManager;
	
	public void swap(Object[] message) {
		String command = (String)message[0];
		if( CommandGroup.isIoModule(command) ) {
			ioDispatcher.in(message);
		}else {
			swapManager.swap(message);
		}
	}
	
}
