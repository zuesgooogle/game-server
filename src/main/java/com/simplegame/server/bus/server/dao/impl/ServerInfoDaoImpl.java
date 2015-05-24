package com.simplegame.server.bus.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.core.data.accessor.dao.AbsDao;
import com.simplegame.server.bus.server.dao.IServerInfoDao;
import com.simplegame.server.bus.server.entity.ServerInfo;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月23日 下午10:13:07 
 *
 */
@Component
public class ServerInfoDaoImpl extends AbsDao<ServerInfo> implements IServerInfoDao {

	@Override
	public List<ServerInfo> loadAll() {
		return getRecords(null, "", AccessType.getDirectDbType());
	}

	@Override
	public void insert(ServerInfo server) {
		insert(server, server.getId(), AccessType.getDirectDbType());
	}

	@Override
	public void update(ServerInfo server) {
		update(server, server.getId(), AccessType.getDirectDbType());
	}

}
