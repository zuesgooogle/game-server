package com.simplegame.server.bus.client.io.event.publish;

import com.simplegame.core.event.IEvent;
import com.simplegame.server.share.event.EventConstants;

public class RoleLoginEvent implements IEvent {
    
    private Object[] data = null;

    public RoleLoginEvent(String roleId, String ip) {
        this.data = new Object[] { roleId, ip };
    }

    public String getType() {
        return EventConstants.ROLE_LOGIN;
    }

    public Object getData() {
        return this.data;
    }

    public Object getSource() {
        return this.data[0];
    }
}
