package com.simplegame.server.message;

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
	
	public static int getDestType(Object[] message) {
		return ((Integer) message[2]).intValue();
	}

	public static int getFromType(Object[] message) {
		return ((Integer) message[3]).intValue();
	}
}
