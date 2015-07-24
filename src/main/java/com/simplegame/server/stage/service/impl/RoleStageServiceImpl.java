package com.simplegame.server.stage.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.server.bus.map.MapType;
import com.simplegame.server.bus.map.configure.IMapConfigExportService;
import com.simplegame.server.bus.stagecontroll.position.AbsRolePosition;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.stage.dao.IRoleStageDao;
import com.simplegame.server.stage.entity.RoleStage;
import com.simplegame.server.stage.model.core.stage.ElementType;
import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.model.element.role.IRole;
import com.simplegame.server.stage.service.IRoleStageService;
import com.simplegame.server.stage.service.IStageService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 下午3:52:58
 *
 */ 
@Component
public class RoleStageServiceImpl implements IRoleStageService {

    private Logger LOG = LoggerFactory.getLogger(getClass());
    
    @Resource
    private IRoleStageDao roleStageDao;
    
    @Resource
    private IStageService stageService;
    
    @Resource
    private IMapConfigExportService mapConfigExportService;
    
    @Resource
    private IStageControllService stageControllService;
    
    @Override
    public void createRoleStage(String roleId, int level) {
        RoleStage roleStage = new RoleStage();

        roleStage.setUserRoleId(roleId);
        
        //ZhuJueAttributeConfig localZhuJueAttributeConfig = this.zhujueAttributeExportService.loadByLevel(Integer.valueOf(paramInt));
        roleStage.setMaxHp(1000);
        roleStage.setMaxMp(1000);
        roleStage.setHp(1000);
        roleStage.setMp(1000);
        roleStage.setState(0);
        roleStage.setTiLi(1);
        
        //ZuoBiaoConfig localZuoBiaoConfig = this.bornZuoBiaoConfigExportService.loadByChusheng();
        //List localList = localZuoBiaoConfig.getZuobiaoChusheng();
        //int i = Lottery.roll(localList.size());
        //Integer[] arrayOfInteger = (Integer[])localList.get(i);
        
        roleStage.setMapId("1");
        roleStage.setMapX(100);
        roleStage.setMapY(200);
        this.roleStageDao.createRoleStage(roleStage, roleId);
      }

    @Override
    public RoleStage loadRoleStage(String roleId) {
        return roleStageDao.cacheLoad(roleId, roleId);
    }

    @Override
    public void syncRoleStageData(String roleId, String stageId) {
        IStage stage = stageService.getStage(stageId);
        IRole role = stage.getElement(roleId, ElementType.ROLE);
        
        if( null == role ) {
            LOG.error("sync role stage data error. role: {} not found.", roleId);
        }
        
        int mapType = mapConfigExportService.load(stage.getMapId()).getMayType();
        
        String mapId = null;
        int x = 0;
        int y = 0;
        
        if( stage.isCopy() || !MapType.usedForOfflineSave(mapType) ) {
            AbsRolePosition rolePosition = stageControllService.getOfflineSaveMapPosition(roleId);
            
            mapId = rolePosition.getMapId();
            x = rolePosition.getX();
            y = rolePosition.getY();
        }
        
        //更新缓存
        RoleStage roleStage = this.roleStageDao.cacheLoad(roleId, roleId);
        
        roleStage.setMapId(mapId);
        roleStage.setMapX(x);
        roleStage.setMapY(y);
        
        roleStageDao.cacheUpdate(roleStage, roleId);
    }

}
