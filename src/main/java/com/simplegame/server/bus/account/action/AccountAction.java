package com.simplegame.server.bus.account.action;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月6日 上午11:09:18
 *
 */
@ActionWorker
public class AccountAction {

	@ActionMapping(mapping = "13001")
	public void getMoneyData() {
		
	}
	
}
