package com.simplegame.server.gamerule.goods.configure.export.impl;

import org.springframework.stereotype.Component;

import com.simplegame.server.configure.parser.impl.AbsClasspathConfigureParser;
import com.simplegame.server.gamerule.goods.configure.export.IGoodsConfigService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月28日 下午3:04:45
 *
 */
@Component
public class GoodsConfigServiceImpl extends AbsClasspathConfigureParser implements IGoodsConfigService {

    @Override
    public GoodsConfig loadById(String goodsConfigId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void configureDataResolve(byte[] bytes) {
        // TODO Auto-generated method stub

    }

    @Override
    protected String getConfigureName() {
        // TODO Auto-generated method stub
        return null;
    }

}
