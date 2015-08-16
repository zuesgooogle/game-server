package com.simplegame.server.bus.equip.util;

import com.simplegame.server.bus.bag.constants.BagConstants;
import com.simplegame.server.bus.equip.constants.EquipConstants;

public class EquipUtils {
	
	public static boolean isEquipSlot(int slotNum) {
		return (slotNum <= EquipConstants.EQUIT_SLOT_MAX && slotNum >= EquipConstants.EQUIT_SLOT_MIN);
	}

	public static boolean isBagSlot(int slotNum) {
		return (slotNum <= BagConstants.BAG_MAX) && (slotNum >= BagConstants.BAG_MIN);
	}
}