package com.simplegame.server.bus.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.action.front.IActionFrontend;
import com.simplegame.core.message.Message;
import com.simplegame.server.executor.IBusinessExecutor;
import com.simplegame.server.executor.IRunnable;
import com.simplegame.server.executor.Route;
import com.simplegame.server.executor.impl.RunnableImpl;
import com.simplegame.server.message.IMsgDispatcher;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月9日 下午5:47:55
 * 
 */
@Component(value = "busDispatcher")
public class BusMsgDispatcher implements IMsgDispatcher {

	private ThreadLocal<IRunnable> runnableLocal = new ThreadLocal<IRunnable>();

	private BusRouteHelper routeHelper = new BusRouteHelper();

	@Resource(name = "busExecutor")
	private IBusinessExecutor businessExexutor;

	@Resource(name = "actionFrontend")
	private IActionFrontend actionFrontend;

	@Override
	public void in(Message message) {
		Runnable runnable = getRunnable().getRunnable(message);
		
		Route route = this.routeHelper.getRoute(message);
		this.businessExexutor.execute(runnable, route);
	}

	private IRunnable getRunnable() {
		IRunnable runnalbe = this.runnableLocal.get();
		if (null == runnalbe) {
			runnalbe = new RunnableImpl(this.actionFrontend);
			this.runnableLocal.set(runnalbe);
		}
		return runnalbe;
	}

}
