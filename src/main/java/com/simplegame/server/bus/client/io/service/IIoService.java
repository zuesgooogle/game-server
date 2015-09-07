package com.simplegame.server.bus.client.io.service;

public interface IIoService {
    
    public void roleIn(String roleId, String ip);

    public void roleOut(String roleId);

    public void roleOutOnServerClose(String roleId);

    public void syncRoleOut(String roleId);

    public void syncRoleIn(String roleId, String ip);
}
