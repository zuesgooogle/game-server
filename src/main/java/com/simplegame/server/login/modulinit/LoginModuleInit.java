package com.simplegame.server.login.modulinit;

import org.springframework.stereotype.Component;

import com.simplegame.server.login.LoginModuleInfo;
import com.simplegame.server.login.commond.LoginCommands;
import com.simplegame.server.public_.share.PublicModuleInit;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.moduleinit.CommandGroup;


/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午2:58:03
 *
 */
@Component
public class LoginModuleInit extends PublicModuleInit {

	@Override
	protected InCmd getInCmd() {
		return new InCmd(LoginModuleInfo.MODULE_NAME, CommandGroup.GROUP_LOGIN, new String[] {LoginCommands.IN, LoginCommands.CREATE_ROLE});
	}

	@Override
	public EventHandleCommands getEventHandleCommands() {
		return null;
	}

}
