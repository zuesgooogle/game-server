package com.simplegame.server.bus.share.dao;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.core.data.accessor.dao.AbsCacheDao;
import com.simplegame.core.data.accessor.dao.ICacheInitDaoOperation;



/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月21日 下午5:59:40
 * 
 */

@SuppressWarnings("unchecked")
public abstract class BusAbsCacheDao<T extends IEntity> extends AbsCacheDao<T> implements ICacheInitDaoOperation<T> {
	
	public String getAccessType() {
		return AccessType.getRoleCacheDbType();
	}
}