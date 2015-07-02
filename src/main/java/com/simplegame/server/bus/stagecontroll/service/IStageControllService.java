package com.simplegame.server.bus.stagecontroll.service;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:01:16
 *
 */

public interface IStageControllService {

    public Object login(String roleId);
    
    public Object logout(String roleId);
}
