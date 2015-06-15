package com.simplegame.server.public_.share.service;

import java.util.Collection;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月11日 下午4:12:14
 * 
 */
public interface IPublicRoleStateService {

	public void change2PublicOnline(String userRoleId);

	public void change2PublicOffline(String userRoleId);

	public boolean isPublicOnline(String userRoleId);

	public Collection<String> getAllOnlineRoleIds();

}
