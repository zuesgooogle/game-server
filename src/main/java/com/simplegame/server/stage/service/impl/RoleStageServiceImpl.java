package com.simplegame.server.stage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.stage.dao.IRoleStageDao;
import com.simplegame.server.stage.entity.RoleStage;
import com.simplegame.server.stage.service.IRoleStageService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 下午3:52:58
 *
 */ 
@Component
public class RoleStageServiceImpl implements IRoleStageService {

    @Resource
    private IRoleStageDao roleStageDao;
    
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

}
