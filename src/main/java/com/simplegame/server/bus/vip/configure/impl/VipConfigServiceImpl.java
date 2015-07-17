package com.simplegame.server.bus.vip.configure.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simplegame.server.bus.vip.configure.IVipConfigureService;
import com.simplegame.server.configure.export.IConfigureExportService;
import com.simplegame.server.configure.parser.impl.AbsClasspathConfigureParser;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月3日 上午11:58:32
 *
 */
@Component
public class VipConfigServiceImpl extends AbsClasspathConfigureParser implements IVipConfigureService {

    private Logger LOG = LoggerFactory.getLogger(getClass());
    
    private static final String CONFIGURE_NAME = "vip.dat";
    
    @Resource
    private IConfigureExportService configureExportService;
    
    @Override
    protected void configureDataResolve(byte[] bytes) {
        String data = new String(bytes);
        
        JSONArray array = JSON.parseArray(data);
        for (Object object : array) {
            JSONObject json = (JSONObject)object;
            
            LOG.info("vip config: {}", json.toJSONString());
            
            VipConfig config = createConfig(json);
            configureExportService.add( config );
            
            
            VipConfig c = configureExportService.get(VipConfig.class, config.getLevel());
            LOG.info("" + c.getName());
        }
    }
    
    private VipConfig createConfig(JSONObject json) {
        VipConfig config = new VipConfig();
        config.setLevel(json.getInteger("level"));
        config.setName(json.getString("name"));
        
        return config;
    }

    @Override
    protected String getConfigureName() {
        return CONFIGURE_NAME;
    }

    @Override
    public VipConfig loadByLevel(int level) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
