package com.simplegame.server.stage.configure.export.impl;

import com.simplegame.core.data.IEntity;

public class PublicCdConfig implements IEntity {
    
    private static final long serialVersionUID = 1L;
    
    public String cdId;
    
    public int cdTime;

    public String getCdId() {
        return this.cdId;
    }

    void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public int getCdTime() {
        return this.cdTime;
    }

    void setCdTime(int cdTime) {
        this.cdTime = cdTime;
    }

    public String getPirmaryKeyName() {
        return "cdId";
    }

    public String getPrimaryKeyValue() {
        return this.cdId;
    }

    public IEntity copy() {
        PublicCdConfig publicCdConfig = new PublicCdConfig();
        publicCdConfig.setCdId(getCdId());
        publicCdConfig.setCdTime(getCdTime());
        return publicCdConfig;
    }
}
