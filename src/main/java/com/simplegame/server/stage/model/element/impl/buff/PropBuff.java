package com.simplegame.server.stage.model.element.impl.buff;

import com.simplegame.server.gamerule.goods.configure.export.impl.GoodsConfig;
import com.simplegame.server.stage.configure.export.impl.BuffConfig;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月28日 下午2:51:19
 *
 */

public class PropBuff extends Buff {

    private GoodsConfig goodsConfig;
    
    public PropBuff(String id, GoodsConfig goodsConfig, BuffConfig buffConfig) {
        super(id, buffConfig);
        this.goodsConfig = goodsConfig;
    }
    
    public GoodsConfig getGoodsConfig() {
        return this.goodsConfig;
    }

}
