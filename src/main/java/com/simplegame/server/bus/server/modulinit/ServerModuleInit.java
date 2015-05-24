package com.simplegame.server.bus.server.modulinit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.server.service.IServerInfoService;
import com.simplegame.server.bus.share.moduleinit.BusModuleInit;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月23日 下午9:26:21 
 *
 */
@Component
public class ServerModuleInit extends BusModuleInit {

	@Resource
	private IServerInfoService serverInfoService;
	
	@Override
	public void moduleInit() {
		serverInfoService.init();
	}
	
	@Override
	public int getOrder() {
		return 100;
	}

	@Override
	protected InCmd getInCmd() {
		return null;
	}

}
