package com.simplegame.server.public_.nodecontrol.service;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月11日 下午3:59:40
 * 
 */
public interface INodeControlService {

	public void change2online(String userRoleId);

	public void change2offline(String userRoleId);

	public void nodeLogin(String userRoleId, String paramString2);

	public void nodeExit(String userRoleId, String paramString2);

	public void nodeExitOnServerClose(String userRoleId);

}
