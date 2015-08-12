package com.simplegame.server.bus.bag.dao.filter;

import com.simplegame.core.data.IQueryFilter;
import com.simplegame.server.bus.bag.entity.RoleBagSlot;

/**
*
* @Author zeusgooogle@gmail.com
* @sine   2015年8月11日 下午3:08:57
*
*/
public class StoreSlotFilter implements IQueryFilter<RoleBagSlot> {
    
    private boolean found;
    private int minSlot;
    private int maxSlot;

    public StoreSlotFilter(int min, int max) {
        this.minSlot = min;
        this.maxSlot = max;
    }

    public boolean check(RoleBagSlot roleBagSlot) {
        return (roleBagSlot.getSlotNum() >= this.minSlot) && (roleBagSlot.getSlotNum() <= this.maxSlot);
    }

    public boolean stopped() {
        return this.found;
    }
}
