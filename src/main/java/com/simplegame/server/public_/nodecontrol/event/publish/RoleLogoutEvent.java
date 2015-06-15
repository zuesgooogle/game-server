package com.simplegame.server.public_.nodecontrol.event.publish;

import com.simplegame.core.event.IEvent;

public class RoleLogoutEvent implements IEvent {
	
	private Object[] data = null;

	public RoleLogoutEvent(String paramString1, String paramString2, Long paramLong) {
		this.data = new Object[] { paramString1, paramString2, paramLong, Long.valueOf(System.currentTimeMillis()) };
	}

	@Override
	public String getType() {
		return "role_logout";
	}

	@Override
	public Object getData() {
		return this.data;
	}

	@Override
	public Object getSource() {
		return this.data[0];
	}
}