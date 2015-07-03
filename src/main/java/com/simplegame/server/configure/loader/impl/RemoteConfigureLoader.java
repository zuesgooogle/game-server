package com.simplegame.server.configure.loader.impl;

import com.simplegame.server.configure.loader.DirType;
import com.simplegame.server.configure.loader.IConfigureResourceLoader;

public class RemoteConfigureLoader implements IConfigureResourceLoader {
    
    private String gameconfigBaseUrl;
    
    private String gamedownloadBaseUrl;

    public void setGameconfigBaseUrl(String string) {
        this.gameconfigBaseUrl = string.trim();
    }

    public void setGamedownloadBaseUrl(String string) {
        this.gamedownloadBaseUrl = string;
    }

    @Override
    public byte[] load(String configureName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] loadSign(String configureName, DirType type) {
        // TODO Auto-generated method stub
        return null;
    }

}
