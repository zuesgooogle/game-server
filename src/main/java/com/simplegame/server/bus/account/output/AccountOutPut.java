package com.simplegame.server.bus.account.output;

import com.simplegame.server.bus.account.entity.RoleAccount;
import com.simplegame.server.bus.account.entity.UserAccount;

public class AccountOutPut {
    
    public static Object[] getMoneyChange(UserAccount userAccount, RoleAccount roleAccount) {
        return new Object[] {1, roleAccount.getTongqian(), userAccount.getLingshi(), roleAccount.getBindLingshi()};
    }
    
}
