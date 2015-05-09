package com.simplegame.server.io.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.action.front.IActionFrontend;
import com.simplegame.server.executor.IBusinessExecutor;
import com.simplegame.server.executor.IRunnable;
import com.simplegame.server.executor.impl.RunnableImpl;
import com.simplegame.server.io.message.IoMessage;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午5:59:05
 *
 */
@Component
public class IoMsgDispatcher {

	private ThreadLocal<IRunnable> runnableLocal = new ThreadLocal<IRunnable>();
	
	private IoRouteHelper routeHelper = new IoRouteHelper();
	
	@Resource(name="ioExecutor")
	private IBusinessExecutor businessExexutor;
	
	@Resource(name="actionFrontend")
	private IActionFrontend actionFrontend;
	
	public void in(Object object) {
		IoMessage message = new IoMessage((Object[]) object);
		
		Runnable localRunnable = getRunnable().getRunnable(message);
		this.businessExexutor.execute(localRunnable, this.routeHelper.getRoute(message, message.getRoute()));
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
