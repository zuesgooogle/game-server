package com.simplegame.server.bus.map.configure;

import java.util.List;

import com.simplegame.server.bus.map.configure.export.impl.MapConfig;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年7月17日 上午10:26:13
 * 
 */

public interface IMapConfigExportService {

    public MapConfig load(String id);

    public List<MapConfig> loadAll();

}
