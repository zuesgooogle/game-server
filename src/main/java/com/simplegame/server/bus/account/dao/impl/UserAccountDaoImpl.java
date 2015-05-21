package com.simplegame.server.bus.account.dao.impl;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.account.dao.IUserAccountDao;
import com.simplegame.server.bus.account.entity.UserAccount;
import com.simplegame.server.bus.share.dao.BusAbsCacheDao;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月21日 下午6:12:53
 *
 */
@Component
public class UserAccountDaoImpl extends BusAbsCacheDao<UserAccount> implements IUserAccountDao {

	@Override
	public void insertUserAccount(UserAccount userAccount, String userGuid) {
		// TODO Auto-generated method stub

	} 

	@Override
	public UserAccount initUserAccount(String userGuid, String roleId, String serverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccount getUserAccountDb(String userGuid, String serverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserAccountDb(UserAccount userAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public String generateUserAccountId(String userGuid, String serverId) {
		// TODO Auto-generated method stub
		return null;
	}

}
