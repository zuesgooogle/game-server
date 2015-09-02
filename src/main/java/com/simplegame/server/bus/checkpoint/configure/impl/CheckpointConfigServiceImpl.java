package com.simplegame.server.bus.checkpoint.configure.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.simplegame.server.bus.checkpoint.configure.ICheckpointConfigService;
import com.simplegame.server.configure.export.IConfigureExportService;
import com.simplegame.server.configure.parser.impl.AbsClasspathConfigureParser;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月1日 下午2:46:58
 *
 */
@Component
public class CheckpointConfigServiceImpl extends AbsClasspathConfigureParser implements ICheckpointConfigService {

    @Resource
    private IConfigureExportService configureExportService;
    
    @Override
    protected void configureDataResolve(byte[] bytes) {
        String data = new String(bytes);
        
        JSONArray array = JSON.parseArray(data);
        for (Object object : array) {
            JSONObject json = (JSONObject)object;

            configureExportService.add( createConfig(json) );
        }
        
    }
    
    private CheckpointConfig createConfig(JSONObject json) {
        CheckpointConfig entity = JSON.parseObject(json.toJSONString(), CheckpointConfig.class);
        
        return entity;
    }

    @Override
    protected String getConfigureName() {
        return "checkpoint.dat";
    }

    @Override
    public CheckpointConfig loadById(String id) {
        return configureExportService.get(CheckpointConfig.class, id);
    }

}
