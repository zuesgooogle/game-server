package com.simplegame.server.bus.client.io.event.publish;

import com.simplegame.core.event.IEvent;

public class RoleLoginEvent implements IEvent {
    
    private Object[] data = null;

    public RoleLoginEvent(String roleId, String paramString2) {
        this.data = new Object[] { roleId, paramString2 };
    }

    public String getType() {
        return "role_login";
    }

    public Object getData() {
        return this.data;
    }

    public Object getSource() {
        return this.data[0];
    }
}
