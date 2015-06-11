package com.simplegame.server.bus.role.output;

import com.simplegame.server.bus.role.entity.UserRole;

public class GetRoleOutput {
	
	public static Object roleInfo(UserRole userRole) {
		
		return new Object[] { 
				userRole.getId(), 
				userRole.getName(), 
				userRole.getJob(), 
				userRole.getSex(), 
				userRole.getLevel(), 
				userRole.getFace(),
				Long.valueOf(userRole.getCreateTime().getTime())
			};
	}
}
