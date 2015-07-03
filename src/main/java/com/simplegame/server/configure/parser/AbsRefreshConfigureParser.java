package com.simplegame.server.configure.parser;

import javax.annotation.Resource;

import com.simplegame.core.utils.Md5Utils;
import com.simplegame.server.configure.loader.DirType;
import com.simplegame.server.configure.schedule.RefreshableConfigureScheduler;

public abstract class AbsRefreshConfigureParser extends AbsConfigureParser {
    
    @Resource
    private RefreshableConfigureScheduler scheduler;

    @Override
    public void init() {
        super.init();
        this.scheduler.addRefreshableParser(this);
    }

    public void directRefresh() {
        try {
            Object[] signInfo = this.getLoader().loadSign(this.getConfigureName(), DirType.GLOBAL);
            String sign = (String) signInfo[0];
            String configureName = (String) signInfo[1];
            
            this.refresh(configureName, sign);
        } catch (Exception e) {
            LOG.error("configureName: {}, direct refresh failed. message: {}", this.getConfigureName(), e);
        }
    }

    public void versionRefresh() {
        try {
            Object[] signInfo = this.getLoader().loadSign(this.getConfigureName(), DirType.GLOBAL);
            String sign = (String) signInfo[0];
            String configureName = (String) signInfo[1];
            
            if (!(null != this.sign && this.sign.equals(sign))) {
                this.refresh(configureName, sign);
            }
        } catch (Exception e) {
            LOG.error("configureName: {}, version refresh failed. message: {}", this.getConfigureName(), e);
        }
    }

    private void refresh(String configureName, String sign) {
        byte[] bytes = this.getLoader().load(configureName);
        if (!(sign == null || sign.equals(Md5Utils.md5Bytes(bytes)))) {
            return;
        }
        
        this.sign = sign;
        this.clearData();
        this.configureDataResolve(bytes);
    }

    protected abstract void clearData();

    public String getConfigName() {
        return this.getConfigureName();
    }
}
