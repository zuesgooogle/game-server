package com.simplegame.server.stage.dao.impl;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.server.bus.share.dao.BusAbsCacheDao;
import com.simplegame.server.stage.dao.IRoleStageDao;
import com.simplegame.server.stage.entity.RoleStage;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 下午3:31:03
 *
 */
@Component
public class RoleStageDaoImpl extends BusAbsCacheDao<RoleStage> implements IRoleStageDao {

    @Override
    public void createRoleStage(RoleStage roleStage, String roleId) {
        insert(roleStage, roleId, AccessType.getDirectDbType());
    }

}
