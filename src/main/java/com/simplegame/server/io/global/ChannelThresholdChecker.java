package com.simplegame.server.io.global;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月5日 下午10:16:17 
 *
 */
@Component
public class ChannelThresholdChecker {

	@Resource
	private ChannelManager channelManager;
	
	/**
	 * The number at the same time online
	 * 
	 * default: 2000
	 */
	private int maxCount = 2000;
	
	/**
	 * ip blacklist
	 */
	private Set<String> blacklist = new HashSet<String>();
	
	public boolean isFull() {
		return channelManager.getSessionCount() >= maxCount;
	}
	
	public boolean isBlackIp(String ip) {
		return blacklist.contains(ip);
	}
}
