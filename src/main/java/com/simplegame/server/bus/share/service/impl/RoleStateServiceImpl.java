package com.simplegame.server.bus.share.service.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

import com.simplegame.core.sync.Sync;
import com.simplegame.server.bus.share.service.IRoleStateService;

@Component
public class RoleStateServiceImpl implements IRoleStateService {
	
	private ConcurrentMap<String, String> roleStates = new ConcurrentHashMap<String, String>();

	@Sync(component = "bus_share", indexes = { 0 })
	public void change2online(String paramString) {
		this.roleStates.put(paramString, paramString);
	}

	@Sync(component = "bus_share", indexes = { 0 })
	public void change2offline(String paramString) {
		this.roleStates.remove(paramString);
	}

	public boolean isOnline(String paramString) {
		return this.roleStates.containsKey(paramString);
	}

	public Collection<String> getAllOnlineRoleids() {
		return this.roleStates.values();
	}
}