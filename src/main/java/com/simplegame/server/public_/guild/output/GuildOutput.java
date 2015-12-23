package com.simplegame.server.public_.guild.output;

import com.simplegame.server.gamerule.errorcode.GeneralErrorCode;

public class GuildOutput {

    public static Object[] targetNotGuild() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470048) };
    }

    public static Object[] targetGuildFull() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470012) };
    }

    public static Object[] roleLevelNotEnough() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470061) };
    }

    public static Object[] targetLevelNotEnough() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470043) };
    }

    public static Object[] inGuild() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470011) };
    }

    public static Object[] notInGuild() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470018) };
    }

    public static Object[] guildAdminOffline() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470013) };
    }

    public static Object[] guildExit() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470017) };
    }

    public static Object[] roleGuildHas(String paramString) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470019), paramString };
    }

    public static Object[] guildMaxCount(int paramInt) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470014), Integer.valueOf(paramInt) };
    }
    
    public static Object[] roleOffline(String paramString) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470020), paramString };
    }

    public static Object[] guildNameNotNull() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470000) };
    }

    public static Object[] inGuildExit() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470002) };
    }

    public static Object[] guildNameStringlength() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470003) };
    }

    public static Object[] guildNameIllegal() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470004) };
    }

    public static Object[] guildNameExisted() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470005) };
    }

    public static Object[] createGuildMoneyNotEnough() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470009) };
    }

    public static Object[] createGuildLevelNotEnough() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470010) };
    }

    public static Object[] noExitGuild() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470023) };
    }

    public static Object[] noTichuGuild() {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470024) };
    }

    public static Object[] autoGuildDel(int paramInt) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470049), Integer.valueOf(paramInt) };
    }

    public static Object[] delGuild(String paramString1, String paramString2) {
        return new Object[] { Integer.valueOf(1), Integer.valueOf(470065), paramString1, paramString2 };
    }

    public static Object[] moneyNotEnough() {
        return new Object[] { Integer.valueOf(0), GeneralErrorCode.JB_NOT_ENOUGH };
    }

    public static Object[] goodsNotEnough() {
        return new Object[] { Integer.valueOf(0), GeneralErrorCode.GOODS_NOT_ENOUGH };
    }

    public static Object[] guildGoodsTop(String paramString) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470059), new Object[] { paramString } };
    }

    public static Object[] guildGoodsNotEnough(String paramString) {
        return new Object[] { Integer.valueOf(0), Integer.valueOf(470038), paramString };
    }

}