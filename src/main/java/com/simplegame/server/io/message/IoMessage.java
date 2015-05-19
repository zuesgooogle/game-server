package com.simplegame.server.io.message;

import com.simplegame.protocol.message.Message;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午6:04:42
 *
 */

public class IoMessage extends Message {

	public static final String IO_MSG_OUT_CMD = "io_msg_out";

	public IoMessage(Object[] msgSource) {
		super(msgSource);
	}

	@Override
	public String getCommand() {
		String str = super.getCommand();
		if (CommandGroup.isIoModule(str)) {
			return str;
		}
		return IO_MSG_OUT_CMD;
	}
}
