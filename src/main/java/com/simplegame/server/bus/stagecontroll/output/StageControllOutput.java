package com.simplegame.server.bus.stagecontroll.output;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.stage.export.RoleStageWrapper;

@Component
public class StageControllOutput {
    
	public static Object login(RoleWrapper roleWrapper, RoleStageWrapper roleStageWrapper, int vipLevel, Object[] chargeInfo, int gmState) {
		return new Object[] {
				Integer.valueOf(1),
				new Object[] { roleWrapper.getFace(), roleWrapper.getLevel(), roleWrapper.getExp(), roleWrapper.getSex(),
						roleWrapper.getJob(), Boolean.valueOf(roleWrapper.isChenmi()),
						vipLevel, chargeInfo, gmState },
				new Object[] { roleStageWrapper.getMapId(), roleStageWrapper.getMapX(), roleStageWrapper.getMapY() } };
	}

	public static Object[] applyChangeMap(Object paramObject1, Object paramObject2, Object paramObject3) {
		return new Object[] { Integer.valueOf(1), paramObject1, new Object[] { paramObject2, paramObject3 } };
	}

}