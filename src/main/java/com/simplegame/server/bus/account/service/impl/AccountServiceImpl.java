package com.simplegame.server.bus.account.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.account.AccountConstants;
import com.simplegame.server.bus.account.AccountModuleInfo;
import com.simplegame.server.bus.account.dao.IRoleAccountDao;
import com.simplegame.server.bus.account.dao.IUserAccountDao;
import com.simplegame.server.bus.account.entity.RoleAccount;
import com.simplegame.server.bus.account.entity.UserAccount;
import com.simplegame.server.bus.account.service.IAccountService;
import com.simplegame.server.bus.id.export.IdGenerator;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.role.service.IUserRoleService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年6月8日 下午6:15:44
 *
 */
@Component
public class AccountServiceImpl implements IAccountService {

	@Resource
	private IUserAccountDao userAccountDao;
	
	@Resource
	private IRoleAccountDao roleAccountDao;
	
	@Resource
	private IdGenerator idGenerator;
	
	@Resource
	private IUserRoleService userRoleService;
	
	@Override
	public void createAccount(String userGuid, String userRoleId) {
		RoleAccount roleAccount = new RoleAccount();
		roleAccount = new RoleAccount();
		roleAccount.setId(idGenerator.getId4Module(AccountModuleInfo.MODULE_NAME));
		
		roleAccount.setUserRoleId(userRoleId);
		roleAccount.setTongqian(Long.valueOf(0L));
		roleAccount.setCreateTime(new Timestamp(System.currentTimeMillis()));
		roleAccount.setBindLingshi(Long.valueOf(0L));
		this.roleAccountDao.insertRoleAccount(roleAccount);
		
		RoleWrapper roleWrapper = userRoleService.getRole(userRoleId);
		UserAccount userAccount = this.userAccountDao.getUserAccountDb(userGuid, roleWrapper.getServerId());
		if (userAccount == null) {
			userAccount = new UserAccount();
			userAccount.setId(this.userAccountDao.generateUserAccountId(userGuid, roleWrapper.getServerId()));
			userAccount.setUserGuid(userGuid);
			userAccount.setLingshi(Long.valueOf(0L));
			userAccount.setReciveYb(Integer.valueOf(0));
			userAccount.setIsRecharge(AccountConstants.NO_RECHARGE);
			userAccount.setCreateTime(new Timestamp(System.currentTimeMillis()));
			userAccount.setServerId(roleWrapper.getServerId());
			
			this.userAccountDao.insertUserAccount(userAccount, userRoleId);
		}
	}
}
