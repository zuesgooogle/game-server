package com.simplegame.server.message;

import com.simplegame.protocol.message.Message;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月10日 下午8:28:52 
 *
 */
public interface IMsgDispatcher {

	public void in(Message message);
	
}
