package com.simplegame.server.public_.nodecontrol.event.publish;

import com.simplegame.core.event.IEvent;
import com.simplegame.server.share.event.EventConstants;

public class RoleLogoutEvent implements IEvent {
	
	private Object[] data = null;

	public RoleLogoutEvent(String roleId, String ip, long onlineTime) {
		this.data = new Object[] { roleId, ip, onlineTime };
	}

	@Override
	public String getType() {
		return EventConstants.ROLE_LOGOUT;
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