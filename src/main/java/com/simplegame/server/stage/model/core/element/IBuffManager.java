package com.simplegame.server.stage.model.core.element;

import java.util.Collection;

public interface IBuffManager extends IElementComponent {
    
    public void addBuff(IBuff buff);

    public void recoverBuff(IBuff buff);

    public void removeBuff(String paramString1, String paramString2);

    public IBuff getBuff(String paramString1, String paramString2);

    public IBuff getBuff(String paramString);

    public Collection<IBuff> getBuffs();

    public void startReadyForRecoveredBuffsAll();

    public void clearBuffsByDead();

    public void clearAll();

    public Object getBuffClientMsgs();

    public IBuff getBuffById(String paramString);

    //public BuffStatistics getBuffStatistics();
}
