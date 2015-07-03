package com.simplegame.server.configure.parser.impl;

import javax.annotation.Resource;

import com.simplegame.server.configure.loader.IConfigureResourceLoader;
import com.simplegame.server.configure.loader.impl.ClasspathConfigureLoader;
import com.simplegame.server.configure.parser.AbsConfigureParser;

public abstract class AbsClasspathConfigureParser extends AbsConfigureParser {
    
    @Resource
    private ClasspathConfigureLoader configureLoader;

    @Override
    protected IConfigureResourceLoader getLoader() {
        return this.configureLoader;
    }
}
