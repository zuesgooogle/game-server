package com.simplegame.server.stage.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.action.front.IActionFrontend;
import com.simplegame.protocol.message.Message;
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
@Component(value = "stageDispatcher")
public class StageMsgDispatcher implements IMsgDispatcher {

	private ThreadLocal<IRunnable> runnableLocal = new ThreadLocal<IRunnable>();

	private StageRouteHelpler routeHelper = new StageRouteHelpler();

	@Resource(name = "stageExecutor")
	private IBusinessExecutor businessExexutor;

	@Resource(name = "actionFrontend")
	private IActionFrontend actionFrontend;

	@Override
	public void in(Object message) {

		Object[] dataSource = (Object[]) message;
		Message msg = new Message(dataSource);
		Runnable localRunnable = getRunnable().getRunnable(msg);
		
		Route localRouteInfo = this.routeHelper.getRoute(msg, ((Integer) dataSource[2]).intValue());
		this.businessExexutor.execute(localRunnable, localRouteInfo);

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
