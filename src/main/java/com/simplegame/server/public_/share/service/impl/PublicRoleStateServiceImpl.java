package com.simplegame.server.public_.share.service.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

import com.simplegame.core.sync.annotation.Sync;
import com.simplegame.server.public_.share.constants.PublicNodeConstants;
import com.simplegame.server.public_.share.service.IPublicRoleStateService;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月11日 下午4:13:57
 * 
 */
@Component
public class PublicRoleStateServiceImpl implements IPublicRoleStateService {
	
	private ConcurrentMap<String, String> publicRoleStates = new ConcurrentHashMap<String, String>();

	@Sync(component = PublicNodeConstants.PUBLIC_COMPONENT_NAME, indexes = { 0 })
	@Override
	public void change2PublicOnline(String userRoleId) {
		publicRoleStates.put(userRoleId, userRoleId);
	}

	@Sync(component = PublicNodeConstants.PUBLIC_COMPONENT_NAME, indexes = { 0 })
	@Override
	public void change2PublicOffline(String userRoleId) {
		publicRoleStates.remove(userRoleId);
	}

	@Override
	public boolean isPublicOnline(String userRoleId) {
		return publicRoleStates.containsKey(userRoleId);
	}

	@Override
	public Collection<String> getAllOnlineRoleIds() {
		return publicRoleStates.values();
	}

}
