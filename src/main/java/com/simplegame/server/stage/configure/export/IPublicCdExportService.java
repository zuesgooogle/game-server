package com.simplegame.server.stage.configure.export;

import com.simplegame.server.stage.configure.export.impl.PublicCdConfig;

public interface IPublicCdExportService {
    
    public PublicCdConfig loadById(String id);
    
}
