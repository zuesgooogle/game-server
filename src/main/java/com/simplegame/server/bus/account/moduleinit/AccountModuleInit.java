package com.simplegame.server.bus.account.moduleinit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.IEntityCacheModelLoader;
import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.account.AccountModuleInfo;
import com.simplegame.server.bus.account.cache.AccountCacheModelLoader;
import com.simplegame.server.bus.account.command.AccountCommands;
import com.simplegame.server.bus.account.event.subscribe.AccountEventHandler;
import com.simplegame.server.bus.share.moduleinit.BusModuleInit;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月4日 下午3:52:12
 * 
 */
@Component
public class AccountModuleInit extends BusModuleInit {

	@Resource
	private AccountEventHandler accountEventHandler;
	
	@Resource
	private AccountCacheModelLoader accountCacheModelLoader;
	
	@Override
	protected InCmd getInCmd() {
		String[] cmds = new String[] { AccountCommands.MONRY_CHANGE, AccountCommands.RECIVE_RECIVE_YB, AccountCommands.ACCOUNT_RECIVE_YB };
		
		return new InCmd(AccountModuleInfo.MODULE_NAME, CommandGroup.GROUP_BUS, cmds);
	}

	protected EventHandleCommands getEventHandleCommands() {

		EventHandleCommands eventHandleCommands = new EventHandleCommands();
		eventHandleCommands.add("role_login", "32010");

		return eventHandleCommands;
	}

	protected ModuleInfo getModuleInfo() {
		return new ModuleInfo(AccountModuleInfo.MODULE_NAME, AccountModuleInfo.MODULE_NAME_ALIAS);
	}

	@Override
	protected IEntityCacheModelLoader[] getEntityCacheModelLoaders() {
		return new IEntityCacheModelLoader[] { this.accountCacheModelLoader };
	}
	
	@Override
	protected IEventHandler[] getEventHandlers() {
		return new IEventHandler[] { this.accountEventHandler };
	}
	
	public int getOrder() {
		return 190;
	}
}
