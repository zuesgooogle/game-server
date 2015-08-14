package com.simplegame.server.bus.equip.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.equip.dao.IRoleEquipSlotDao;
import com.simplegame.server.bus.equip.dao.filter.EquipSlotNumFilter;
import com.simplegame.server.bus.equip.service.IRoleEquipSlotService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月14日 下午6:54:42
 *
 */
@Component
public class RoleEquipSlotServiceImpl implements IRoleEquipSlotService {

    @Resource
    private IRoleEquipSlotDao roleEquipSlotDao;
    
    @Override
    public Object[] dressEquip(String roleId, String goodsId, int bagSlot, int equipSlot) {
        // TODO Auto-generated method stub
        return null;
    }

    private boolean existEquip(String roleId, int equipSlot) {
        return this.roleEquipSlotDao.cacheLoadAll(roleId, new EquipSlotNumFilter(equipSlot)) != null;
    }
    
}
