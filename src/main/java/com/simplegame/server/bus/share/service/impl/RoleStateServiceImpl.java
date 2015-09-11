package com.simplegame.server.bus.share.service.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

import com.simplegame.core.sync.annotation.Sync;
import com.simplegame.server.bus.share.constants.BusShareConstant;
import com.simplegame.server.bus.share.service.IRoleStateService;

@Component
public class RoleStateServiceImpl implements IRoleStateService {
	
	private ConcurrentMap<String, String> roleStates = new ConcurrentHashMap<String, String>();

	@Sync(component = BusShareConstant.COMPONENT_NAME, indexes = { 0 })
	public void change2online(String roleId) {
		this.roleStates.put(roleId, roleId);
	}

	@Sync(component = BusShareConstant.COMPONENT_NAME, indexes = { 0 })
	public void change2offline(String roleId) {
		this.roleStates.remove(roleId);
	}

	public boolean isOnline(String roleId) {
		return this.roleStates.containsKey(roleId);
	}

	public Collection<String> getAllOnlineRoleids() {
		return this.roleStates.values();
	}
}