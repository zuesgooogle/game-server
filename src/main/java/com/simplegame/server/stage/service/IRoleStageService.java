package com.simplegame.server.stage.service;

import com.simplegame.server.stage.entity.RoleStage;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年7月17日 下午3:52:19
 * 
 */

public interface IRoleStageService {

    public void createRoleStage(String roleId, int level);

    public RoleStage loadRoleStage(String roleId);

}
