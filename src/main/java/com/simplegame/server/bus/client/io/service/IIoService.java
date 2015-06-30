package com.simplegame.server.bus.client.io.service;

public abstract interface IIoService {
    
    public abstract void roleIn(String roleId, String paramString2);

    public abstract void roleOut(String roleId);

    public abstract void roleOutOnServerClose(String roleId);

    public abstract void syncRoleOut(String roleId);

    public abstract void syncRoleIn(String roleId, Object paramObject);
}
