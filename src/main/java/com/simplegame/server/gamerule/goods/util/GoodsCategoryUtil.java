package com.simplegame.server.gamerule.goods.util;

import org.springframework.stereotype.Component;

@Component
public class GoodsCategoryUtil {
    
    /**
     *  物品排序类型
     */
    public static int GOODS_ORDER_SIZE = 10;
    
    public static final String EQUIP_TYPE = "20";
   


    public static final boolean isEquip(String paramString) {
        return paramString.equals("20");
    }

}
