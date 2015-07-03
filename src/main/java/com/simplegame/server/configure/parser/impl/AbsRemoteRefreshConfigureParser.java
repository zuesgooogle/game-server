/*
 * Decompiled with CFR 0_88.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Qualifier
 */
package com.simplegame.server.configure.parser.impl;

import javax.annotation.Resource;

import com.simplegame.server.configure.loader.IConfigureResourceLoader;
import com.simplegame.server.configure.loader.impl.RemoteConfigureLoader;
import com.simplegame.server.configure.parser.AbsRefreshConfigureParser;
import com.simplegame.server.configure.parser.IRefreshConfigureParser;

public abstract class AbsRemoteRefreshConfigureParser extends AbsRefreshConfigureParser implements IRefreshConfigureParser {
    
    @Resource
    private RemoteConfigureLoader configureLoader;

    @Override
    protected IConfigureResourceLoader getLoader() {
        return this.configureLoader;
    }

    @Override
    public String getConfigName() {
        return this.getConfigureName();
    }
}
