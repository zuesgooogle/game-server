package com.simplegame.server.bus.equip.service;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月14日 下午6:53:01
 *
 */

public interface IRoleEquipSlotService {

    public Object[] dressEquip(String roleId, String goodsId, int bagSlot, int equipSlot);
    
}
