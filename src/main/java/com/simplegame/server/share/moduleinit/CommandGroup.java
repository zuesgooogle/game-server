package com.simplegame.server.share.moduleinit;

import java.util.HashMap;
import java.util.Map;

public class CommandGroup {
	
	public static final String GROUP_IO	 	 = "io";
	public static final String GROUP_LOGIN	 = "login";
	public static final String GROUP_BUS	 = "bus";
	public static final String GROUP_STAGE	 = "stage";
	public static final String GROUP_PUBLIC	 = "public";
	public static final String GROUP_SYSTEM	 = "system";
	
	private static Map<String, Integer> groupDestMap = new HashMap<String, Integer>();
	private static Map<String, String> cmdGroupMap = new HashMap<String, String>();
	private static Map<String, String> cmdModuleMap = new HashMap<String, String>();
	private static Map<String, Integer> cmdDestMap = new HashMap<String, Integer>();

	public static void registerCmd(String group, String module, String command) {
		cmdGroupMap.put(command, group);
		cmdModuleMap.put(command, module);
		cmdDestMap.put(command, groupDestMap.get(group));
	}

	public static void registerCmd(String group, String module, String[] cmds) {
		if (null != cmds) {
			for (String command : cmds) {
				registerCmd(group, module, command);
			}
		}
	}

	public boolean isIoModule(String command) {
		String module = cmdModuleMap.get(command);
		if( null == module ) {
			return false;
		}
		
		return module.equals(GROUP_IO);
	}
	
	static {
		groupDestMap.put(GROUP_LOGIN , 1);
		groupDestMap.put(GROUP_BUS	 , 2);
		groupDestMap.put(GROUP_STAGE , 3);
		groupDestMap.put(GROUP_PUBLIC, 4);
		groupDestMap.put(GROUP_SYSTEM, 5);
	}
}