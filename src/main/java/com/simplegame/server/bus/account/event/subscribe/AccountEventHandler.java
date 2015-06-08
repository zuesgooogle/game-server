package com.simplegame.server.bus.account.event.subscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.account.service.IAccountService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年6月8日 下午6:13:34
 *
 */
@Component
public class AccountEventHandler implements IEventHandler {

	@Resource
	private IAccountService accountService;
	
	@Override
	public void handle(Object source, Object data) {
		Object[] t = (Object[])data;
		String userGuid = (String)t[0];
		String userRoleId = (String)t[1];
		
		accountService.createAccount(userGuid, userRoleId);
	}

	@Override
	public String getEventType() {
		return "role_create";
	}

}
