package com.simplegame.server.login.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.login.commond.LoginCommands;
import com.simplegame.server.public_.swap.PublicMsgSender;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 上午11:14:43
 *
 */
@ActionWorker
public class LoginAction {

	@Resource
	private PublicMsgSender msgSender;
	
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@ActionMapping(mapping = LoginCommands.IN )
	public void in(Message message) {
		LOG.info(message.toString());
		
		System.err.println("login in...");
		
		msgSender.send2OneBySessionId(message.getCommand(), "110", message.getSessionId(), message.getData());
	}
	
	@ActionMapping(mapping = LoginCommands.CREATE_ROLE )
	public void createRole(Message message) {
		
	}
	
}
