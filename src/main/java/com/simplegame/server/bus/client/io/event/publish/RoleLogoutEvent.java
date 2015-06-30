package com.simplegame.server.bus.client.io.event.publish;

import com.simplegame.core.event.IEvent;

public class RoleLogoutEvent implements IEvent {
    
    private Object[] data = null;

    public RoleLogoutEvent(String paramString1, String paramString2) {
        this.data = new Object[] { paramString1, paramString2 };
    }

    public String getType() {
        return "role_logout";
    }

    public Object getData() {
        return this.data;
    }

    public Object getSource() {
        return this.data[0];
    }
}
