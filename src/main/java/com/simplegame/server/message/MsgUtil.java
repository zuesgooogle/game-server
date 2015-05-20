package com.simplegame.server.message;

import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月10日 下午8:44:41
 * 
 */
public class MsgUtil {

	public MsgUtil() {
	}

	public static String getCommand(Object[] message) {
		return (String) message[0];
	}

	public static Object getMsgData(Object[] message) {
		return message[1];
	}
	
	public static DestType getDestType(Object[] message) {
		int type = ((Integer) message[2]).intValue();
		return DestType.findType(type);
	}

	public static FromType getFromType(Object[] message) {
		int type = ((Integer) message[3]).intValue();
		return FromType.findType(type);
	}
}
