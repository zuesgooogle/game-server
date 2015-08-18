package com.simplegame.server.bus.account.export.response;

import com.simplegame.server.gamerule.money.MoneyType;

public class CheckResponse {
    
    private boolean success;
    
    private MoneyType moneyType;
    
    private long decr;

    public CheckResponse(boolean success, MoneyType moneyType, long decr) {
        this.success = success;
        this.moneyType = moneyType;
        this.decr = decr;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public MoneyType getEnoughMoneyType() {
        return this.moneyType;
    }

    public long getDecr() {
        return this.decr;
    }
}