package com.simplegame.server.configure.parser;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplegame.server.configure.export.impl.ConfigureContext;
import com.simplegame.server.configure.loader.DirType;
import com.simplegame.server.configure.loader.IConfigureResourceLoader;
import com.simplegame.server.utils.LoggerUtil;

public abstract class AbsConfigureParser {

    protected static final Logger LOG = LoggerFactory.getLogger(LoggerUtil.LOG_CONFIGURE);
    
    protected String sign;
    
    public String _getSign() {
        return this.sign;
    }

    @PostConstruct
    public void init() {
        try {
            Object[] signInfo = getLoader().loadSign(this.getConfigureName(), DirType.GLOBAL);
            if (signInfo == null) {
                return;
            }
            
            this.sign = (String)signInfo[0];
            byte[] bytes = this.getLoader().load( (String)signInfo[1] );
            if (bytes == null) {
                LOG.error("cannot find configureName {}", getConfigureName() );
                return;
            }

            this.configureDataResolve(bytes);
        }
        catch (Exception e) {
            LOG.error("parser configureName: {} error. message: {}", getConfigureName(), e);
        }
    }

    protected abstract void configureDataResolve(byte[] bytes);

    protected abstract String getConfigureName();

    protected abstract IConfigureResourceLoader getLoader();

    protected String getIdentity() {
        return ConfigureContext.CONFIGURE_IDENTITY;
    }

}

