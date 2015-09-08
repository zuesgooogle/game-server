package com.simplegame.server.public_.sync;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.simplegame.core.sync.Lock;
import com.simplegame.core.sync.LockManager;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.public_.share.service.IPublicRoleStateService;

public class PublicSyncAspect {
    
    private final Logger LOG = LogManager.getLogger(getClass());
    
    private LockManager lockManager = null;

    @Resource
    private IPublicRoleStateService publicRoleStateService;

    public void setLockManager(LockManager lockManager) {
        this.lockManager = lockManager;
    }

    public Object sync(ProceedingJoinPoint proceedingJoinPoint) {
        Message message = (Message) proceedingJoinPoint.getArgs()[0];
        Lock lock = this.lockManager.getLock("public", message.getRoleId());
        
        synchronized (lock) {
            try {
                if ((this.publicRoleStateService.isPublicOnline(message.getRoleId())) || ("0".equals(message.getCommand()))) {
                    Object object = proceedingJoinPoint.proceed();
                    return object;
                }
                
                LOG.error("not public online,{}", new Object[] { message.toString() });
                
                return null;
            } catch (Throwable throwable) {
                throw new RuntimeException("error in public sync invoke, " + throwable.getMessage(), throwable);
            }
        }
    }
}