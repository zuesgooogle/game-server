package com.simplegame.server.io.moduleinit;

import org.springframework.stereotype.Component;

import com.simplegame.server.io.IoModuleInfo;
import com.simplegame.server.io.commond.IoCommands;
import com.simplegame.server.public_.share.PublicModuleInit;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午6:44:55
 *
 */
@Component
public class IoModuleInit extends PublicModuleInit {

	@Override
	protected InCmd getInCmd() {
		return new InCmd(IoModuleInfo.MODULE_NAME, CommandGroup.GROUP_IO, new String[] {IoCommands.KICK_OUT, IoCommands.PING});
	}
	
	@Override
	public EventHandleCommands getEventHandleCommands() {
		// TODO Auto-generated method stub
		return null;
	}

}
