package com.simplegame.server.login.action;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.server.login.commond.LoginCommands;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 上午11:14:43
 *
 */
@ActionWorker
public class LoginAction {

	@ActionMapping(mapping = LoginCommands.IN )
	public void in(Object[] message) {
		
	}
	
	@ActionMapping(mapping = LoginCommands.CREATE_ROLE )
	public void createRole(Object[] message) {
		
	}
	
}
