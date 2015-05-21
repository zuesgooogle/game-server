package com.simplegame.server.bus.account.dao;

import com.simplegame.core.data.accessor.dao.ICacheInitDaoOperation;
import com.simplegame.server.bus.account.entity.UserAccount;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月21日 下午6:04:52
 * 
 */

public interface IUserAccountDao extends ICacheInitDaoOperation<UserAccount> {

	public void insertUserAccount(UserAccount userAccount, String userGuid);

	public UserAccount initUserAccount(String userGuid, String roleId, String serverId);

	public UserAccount getUserAccountDb(String userGuid, String serverId);

	public void updateUserAccountDb(UserAccount userAccount);

	public String generateUserAccountId(String userGuid, String serverId);

}
