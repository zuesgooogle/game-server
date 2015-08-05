package com.simplegame.server.stage.configure.export.impl;

import org.springframework.stereotype.Component;

import com.simplegame.server.configure.parser.impl.AbsClasspathConfigureParser;
import com.simplegame.server.stage.configure.export.IPublicCdExportService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月4日 下午3:34:12
 *
 */
@Component
public class PublicCdExportServiceImpl extends AbsClasspathConfigureParser implements IPublicCdExportService {

    @Override
    public PublicCdConfig loadById(String id) {
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
