package com.simplegame.server.gamerule.goods.configure.export.impl;

import java.util.Map;

import com.simplegame.core.data.IEntity;

public class GoodsConfig implements IEntity {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String category;
    private int itemLevel;
    private int rareLevel;
    private int maxStack;
    private boolean ownonly;
    private boolean obtainLocked;
    private boolean splocked;
    private boolean whetherCost;
    private int recycle;
    private int duration;
    private String monsterID;
    private int skill;
    private int levelReq;
    private String job;
    private String useCooldown;
    private boolean useAble;
    private int collectType;
    private int fetchEffect;
    private int addHpNumber;
    private int addMpNumber;
    private int addViptime;
    private int addMoney;
    private int addGold;
    private int addSilver;
    private int addYuanBao;
    private int addExp;
    private int addZhenqi;
    private int addShengwang;
    private int bindYb;
    private String summonId;
    private int shuliandu;
    private int shenji;
    private int openGold;
    private int guildLevelUp;
    private float expRate;
    private int lastTime;
    private String buffId;

    private float luckyChance;

    private Map<String, Float> attributeMap;
    private int maxEatCount;

    private boolean inBag;

    private int sexReq;
    private int maxDurability;
    private boolean equipLocked;
    private boolean whetherRepair;
    private float repair;
    private int maxSockets;
    private int maxIntensify;
    private int suit;
    private int equipType;
    
    /**
     * 排序优先级
     */
    private int sortNum;
    private long fbAddExp;
    private Integer globalDropExpireDuration = Integer.valueOf(0);
    private Integer globalDropCount = Integer.valueOf(0);
    private boolean useAllEnable;
    private float zhenqiJianShao;
    private int dailyDropLimitCount;
    private boolean dailyDropLimit;
    private boolean displayName;
    private boolean dropCountRateInfluence;
    private int incrTili;
    private int bangPaiLevel;
    private boolean jianding;
    private boolean jdcailiao;
    private boolean kaiqicishu;
    private String kaiqifenlei;
    private int vipdian;
    private boolean xuni;
    private int costYb;
    private boolean autoUse;
    private Integer specialType;
    private int consumeOrder;
    private int pkzhi;
    private int needVipLevel;

    public String getId() {
        return this.id;
    }

    void setId(String paramString) {
        this.id = paramString;
    }

    public String getName() {
        return this.name;
    }

    void setName(String paramString) {
        this.name = paramString;
    }

    public int getItemLevel() {
        return this.itemLevel;
    }

    void setItemLevel(int paramInt) {
        this.itemLevel = paramInt;
    }

    public String getCategory() {
        return this.category;
    }

    void setCategory(String paramString) {
        this.category = paramString;
    }

    public int getLevelReq() {
        return this.levelReq;
    }

    void setLevelReq(int paramInt) {
        this.levelReq = paramInt;
    }

    public int getRareLevel() {
        return this.rareLevel;
    }

    void setRareLevel(int paramInt) {
        this.rareLevel = paramInt;
    }

    public int getMaxStack() {
        return this.maxStack;
    }

    void setMaxStack(int paramInt) {
        this.maxStack = paramInt;
    }

    public boolean isOwnonly() {
        return this.ownonly;
    }

    void setOwnonly(boolean paramBoolean) {
        this.ownonly = paramBoolean;
    }

    public boolean isObtainLocked() {
        return this.obtainLocked;
    }

    void setObtainLocked(boolean paramBoolean) {
        this.obtainLocked = paramBoolean;
    }

    public boolean isWhetherCost() {
        return this.whetherCost;
    }

    void setWhetherCost(boolean paramBoolean) {
        this.whetherCost = paramBoolean;
    }

    public int getDuration() {
        return this.duration;
    }

    void setDuration(int paramInt) {
        this.duration = paramInt;
    }

    public boolean isSplocked() {
        return this.splocked;
    }

    void setSplocked(boolean paramBoolean) {
        this.splocked = paramBoolean;
    }

    public int getRecycle() {
        return this.recycle;
    }

    void setRecycle(int paramInt) {
        this.recycle = paramInt;
    }

    public int getFetchEffect() {
        return this.fetchEffect;
    }

    void setFetchEffect(int paramInt) {
        this.fetchEffect = paramInt;
    }

    public int getAddHpNumber() {
        return this.addHpNumber;
    }

    void setAddHpNumber(int paramInt) {
        this.addHpNumber = paramInt;
    }

    public int getAddMpNumber() {
        return this.addMpNumber;
    }

    void setAddMpNumber(int paramInt) {
        this.addMpNumber = paramInt;
    }

    public int getAddViptime() {
        return this.addViptime;
    }

    void setAddViptime(int paramInt) {
        this.addViptime = paramInt;
    }

    public int getAddMoney() {
        return this.addMoney;
    }

    void setAddMoney(int paramInt) {
        this.addMoney = paramInt;
    }

    public int getAddGold() {
        return this.addGold;
    }

    void setAddGold(int paramInt) {
        this.addGold = paramInt;
    }

    public int getAddSilver() {
        return this.addSilver;
    }

    void setAddSilver(int paramInt) {
        this.addSilver = paramInt;
    }

    public int getAddExp() {
        return this.addExp;
    }

    void setAddExp(int paramInt) {
        this.addExp = paramInt;
    }

    public int getAddZhenqi() {
        return this.addZhenqi;
    }

    void setAddZhenqi(int paramInt) {
        this.addZhenqi = paramInt;
    }

    public int getAddShengwang() {
        return this.addShengwang;
    }

    void setAddShengwang(int paramInt) {
        this.addShengwang = paramInt;
    }

    public Map<String, Float> getAttributeMap() {
        return this.attributeMap;
    }

    void setAttributeMap(Map<String, Float> paramMap) {
        this.attributeMap = paramMap;
    }

    public int getMaxEatCount() {
        return this.maxEatCount;
    }

    void setMaxEatCount(int paramInt) {
        this.maxEatCount = paramInt;
    }

    public boolean isUseAble() {
        return this.useAble;
    }

    void setUseAble(boolean paramBoolean) {
        this.useAble = paramBoolean;
    }

    public int getCollectType() {
        return this.collectType;
    }

    void setCollectType(int paramInt) {
        this.collectType = paramInt;
    }

    public String getSummonId() {
        return this.summonId;
    }

    void setSummonId(String paramString) {
        this.summonId = paramString;
    }

    public String getMonsterID() {
        return this.monsterID;
    }

    void setMonsterID(String paramString) {
        this.monsterID = paramString;
    }

    public int getShuliandu() {
        return this.shuliandu;
    }

    void setShuliandu(int paramInt) {
        this.shuliandu = paramInt;
    }

    public int getShenji() {
        return this.shenji;
    }

    void setShenji(int paramInt) {
        this.shenji = paramInt;
    }

    public int getOpenGold() {
        return this.openGold;
    }

    void setOpenGold(int paramInt) {
        this.openGold = paramInt;
    }

    public int getGuildLevelUp() {
        return this.guildLevelUp;
    }

    void setGuildLevelUp(int paramInt) {
        this.guildLevelUp = paramInt;
    }

    public int getSortNum() {
        return this.sortNum;
    }

    void setSortNum(int paramInt) {
        this.sortNum = paramInt;
    }

    public IEntity copy() {
        return null;
    }

    public String getPirmaryKeyName() {
        return "id";
    }

    public String getPrimaryKeyValue() {
        return this.id.trim();
    }

    public boolean isInBag() {
        return this.inBag;
    }

    void setInBag(boolean paramBoolean) {
        this.inBag = paramBoolean;
    }

    public String getJob() {
        return this.job;
    }

    void setJob(String paramString) {
        this.job = paramString;
    }

    public String getUseCooldown() {
        return this.useCooldown;
    }

    void setUseCooldown(String paramString) {
        this.useCooldown = paramString;
    }

    public int getSexReq() {
        return this.sexReq;
    }

    void setSexReq(int paramInt) {
        this.sexReq = paramInt;
    }

    public int getMaxDurability() {
        return this.maxDurability;
    }

    void setMaxDurability(int paramInt) {
        this.maxDurability = paramInt;
    }

    public boolean isEquipLocked() {
        return this.equipLocked;
    }

    void setEquipLocked(boolean paramBoolean) {
        this.equipLocked = paramBoolean;
    }

    public boolean isWhetherRepair() {
        return this.whetherRepair;
    }

    void setWhetherRepair(boolean paramBoolean) {
        this.whetherRepair = paramBoolean;
    }

    public float getRepair() {
        return this.repair;
    }

    void setRepair(float paramFloat) {
        this.repair = paramFloat;
    }

    public int getMaxSockets() {
        return this.maxSockets;
    }

    void setMaxSockets(int paramInt) {
        this.maxSockets = paramInt;
    }

    public int getMaxIntensify() {
        return this.maxIntensify;
    }

    void setMaxIntensify(int paramInt) {
        this.maxIntensify = paramInt;
    }

    public int getSuit() {
        return this.suit;
    }

    void setSuit(int paramInt) {
        this.suit = paramInt;
    }

    public int getSkill() {
        return this.skill;
    }

    void setSkill(int paramInt) {
        this.skill = paramInt;
    }

    public long getFbAddExp() {
        return this.fbAddExp;
    }

    void setFbAddExp(long paramLong) {
        this.fbAddExp = paramLong;
    }

    public Integer getGlobalDropExpireDuration() {
        return this.globalDropExpireDuration;
    }

    public Integer getGlobalDropCount() {
        return this.globalDropCount;
    }

    void setGlobalDropExpireDuration(Integer paramInteger) {
        this.globalDropExpireDuration = paramInteger;
    }

    void setGlobalDropCount(Integer paramInteger) {
        this.globalDropCount = paramInteger;
    }

    public float getExpRate() {
        return this.expRate;
    }

    void setExpRate(float paramFloat) {
        this.expRate = paramFloat;
    }

    public int getLastTime() {
        return this.lastTime;
    }

    void setLastTime(int paramInt) {
        this.lastTime = paramInt;
    }

    public String getBuffId() {
        return this.buffId;
    }

    void setBuffId(String paramString) {
        this.buffId = paramString;
    }

    public int getBindYb() {
        return this.bindYb;
    }

    void setBindYb(int paramInt) {
        this.bindYb = paramInt;
    }

    public boolean isUseAllEnable() {
        return this.useAllEnable;
    }

    void setUseAllEnable(boolean paramBoolean) {
        this.useAllEnable = paramBoolean;
    }

    public float getZhenqiJianShao() {
        return this.zhenqiJianShao;
    }

    void setZhenqiJianShao(float paramFloat) {
        this.zhenqiJianShao = paramFloat;
    }

    public int getCostYb() {
        return this.costYb;
    }

    void setCostYb(int paramInt) {
        this.costYb = paramInt;
    }

    public int getDailyDropLimitCount() {
        return this.dailyDropLimitCount;
    }

    public boolean isDailyDropLimit() {
        return this.dailyDropLimit;
    }

    void setDailyDropLimitCount(int paramInt) {
        this.dailyDropLimitCount = paramInt;
    }

    void setDailyDropLimit(boolean paramBoolean) {
        this.dailyDropLimit = paramBoolean;
    }

    public boolean isDisplayName() {
        return this.displayName;
    }

    void setDisplayName(boolean paramBoolean) {
        this.displayName = paramBoolean;
    }

    public boolean isDropCountRateInfluence() {
        return this.dropCountRateInfluence;
    }

    void setDropCountRateInfluence(boolean paramBoolean) {
        this.dropCountRateInfluence = paramBoolean;
    }

    public int getIncrTili() {
        return this.incrTili;
    }

    void setIncrTili(int paramInt) {
        this.incrTili = paramInt;
    }

    public boolean isAutoUse() {
        return this.autoUse;
    }

    void setAutoUse(boolean paramBoolean) {
        this.autoUse = paramBoolean;
    }

    public Integer getSpecialType() {
        return this.specialType;
    }

    void setSpecialType(Integer paramInteger) {
        this.specialType = paramInteger;
    }

    public int getConsumeOrder() {
        return this.consumeOrder;
    }

    void setConsumeOrder(int paramInt) {
        this.consumeOrder = paramInt;
    }

    public float getLuckyChance() {
        return this.luckyChance;
    }

    void setLuckyChance(float paramFloat) {
        this.luckyChance = paramFloat;
    }

    public int getEquipType() {
        return this.equipType;
    }

    void setEquipType(int paramInt) {
        this.equipType = paramInt;
    }

    public int getVipdian() {
        return this.vipdian;
    }

    void setVipdian(int paramInt) {
        this.vipdian = paramInt;
    }

    public boolean isXuni() {
        return this.xuni;
    }

    void setXuni(boolean paramBoolean) {
        this.xuni = paramBoolean;
    }

    public int getNeedVipLevel() {
        return this.needVipLevel;
    }

    void setNeedVipLevel(int paramInt) {
        this.needVipLevel = paramInt;
    }

    public boolean isJianding() {
        return this.jianding;
    }

    void setJianding(boolean paramBoolean) {
        this.jianding = paramBoolean;
    }

    public boolean isJdcailiao() {
        return this.jdcailiao;
    }

    void setJdcailiao(boolean paramBoolean) {
        this.jdcailiao = paramBoolean;
    }

    public int getBangPaiLevel() {
        return this.bangPaiLevel;
    }

    void setBangPaiLevel(int paramInt) {
        this.bangPaiLevel = paramInt;
    }

    public int getPkzhi() {
        return this.pkzhi;
    }

    void setPkzhi(int paramInt) {
        this.pkzhi = paramInt;
    }

    public int getAddYuanBao() {
        return this.addYuanBao;
    }

    void setAddYuanBao(int paramInt) {
        this.addYuanBao = paramInt;
    }

    public boolean isKaiqicishu() {
        return this.kaiqicishu;
    }

    void setKaiqicishu(boolean paramBoolean) {
        this.kaiqicishu = paramBoolean;
    }

    public String getKaiqifenlei() {
        return this.kaiqifenlei;
    }

    void setKaiqifenlei(String paramString) {
        this.kaiqifenlei = paramString;
    }
}