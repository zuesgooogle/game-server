package com.simplegame.server.bus.account.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.core.message.Message;
import com.simplegame.server.bus.account.command.AccountCommands;
import com.simplegame.server.bus.account.service.IAccountService;
import com.simplegame.server.bus.swap.BusMsgSender;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月6日 上午11:09:18
 *
 */
@ActionWorker
public class AccountAction {

    @Resource
    private IAccountService accountService;
    
    @Resource
    private BusMsgSender busMsgSender;
    
	@ActionMapping(mapping = AccountCommands.MONRY_CHANGE)
	public void getMoneyData(Message message) {
	    String roleId = message.getRoleId();
	    
	    Object[] moneyData = accountService.getMoneyData(roleId);
	    busMsgSender.send2One(AccountCommands.MONRY_CHANGE, roleId, moneyData);
	}
	
}
