package com.simplegame.server.bus.share.service;

import java.util.Collection;

public interface IRoleStateService {

	public void change2online(String userRoleId);

	public void change2offline(String userRoleId);

	public boolean isOnline(String userRoleId);

	public Collection<String> getAllOnlineRoleids();
}