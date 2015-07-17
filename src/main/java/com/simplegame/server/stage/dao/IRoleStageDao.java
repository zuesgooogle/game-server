package com.simplegame.server.stage.dao;

import com.simplegame.core.data.accessor.dao.ICacheInitDaoOperation;
import com.simplegame.server.stage.entity.RoleStage;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 下午3:27:34
 *
 */

public interface IRoleStageDao extends ICacheInitDaoOperation<RoleStage> {

    public void createRoleStage(RoleStage roleStage, String roleId);
    
}
