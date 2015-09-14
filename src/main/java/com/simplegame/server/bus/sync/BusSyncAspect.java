package com.simplegame.server.bus.sync;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.simplegame.core.message.Message;
import com.simplegame.core.sync.Lock;
import com.simplegame.core.sync.LockManager;
import com.simplegame.server.bus.client.io.command.ClientIoCommands;
import com.simplegame.server.bus.share.constants.BusShareConstant;
import com.simplegame.server.bus.share.service.IRoleStateService;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年9月12日 上午10:36:25
 * 
 */
@Component
@Aspect
public class BusSyncAspect {

	private Logger LOG = LogManager.getLogger(getClass());

	@Resource
	private LockManager lockManager;

	@Resource
	private IRoleStateService roleStateService;

	@Pointcut(value = "execution(* com.simplegame.server.bus..*Action.*(..) )")
	public void pointcut() {

	}

	@Around(value = "pointcut()")
	public void run(ProceedingJoinPoint joinpoint) throws Throwable {
		LOG.info(joinpoint.toShortString());

		Message message = (Message) joinpoint.getArgs()[0];
		String command = message.getCommand();
		String roleId = message.getRoleId();

		Lock lock = this.lockManager.getLock(BusShareConstant.COMPONENT_NAME, roleId);

		synchronized (lock) {
			
			if (this.roleStateService.isOnline(roleId) || ClientIoCommands.ROLE_IN.equals(command)) {
				joinpoint.proceed();
				return;
			}
			
			LOG.error("role: {} bus not online. message: {}", roleId, message.toString());
		}
	}

	@AfterThrowing(value = "pointcut()", throwing = "e")
    public void exception(Exception e) {
        LOG.error("execute bus sync aspect error: {}", e.getMessage(), e);
    }

}
