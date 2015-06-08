package com.simplegame.server.bus.role.event.publish;

import com.simplegame.core.event.IEvent;
import com.simplegame.server.bus.role.entity.UserRole;

public class RoleCreateEvent implements IEvent {
	
	private Object[] data;

	public RoleCreateEvent(UserRole userRole) {
		this.data = new Object[] { userRole.getUserId(), userRole.getId(), userRole.getLevel() };
	}

	public Object getData() {
		return this.data;
	}

	public String getType() {
		return "role_create";
	}

	@Override
	public Object getSource() {
		return this.data[1];
	}
}
