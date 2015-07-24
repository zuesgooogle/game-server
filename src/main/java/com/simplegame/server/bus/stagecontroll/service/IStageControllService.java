package com.simplegame.server.bus.stagecontroll.service;

import com.simplegame.server.bus.stagecontroll.position.AbsRolePosition;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:01:16
 *
 */

public interface IStageControllService {

    public Object login(String roleId);
    
    /**
     * 客户端申请进入地图
     * 
     * @param roleId
     * @return
     */
    public Object[] applyChangeMapAfterLogin(String roleId);
    
    public Object logout(String roleId);
    
    public boolean isOnline(String roleId);
    
    
    
    
    public void changeMap(String roleId);
    
    
    public AbsRolePosition getOfflineSaveMapPosition(String roleId);
   
    
    
    public void serverStartInitStage();
    
}
