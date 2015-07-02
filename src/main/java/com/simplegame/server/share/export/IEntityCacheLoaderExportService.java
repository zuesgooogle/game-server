package com.simplegame.server.share.export;

import com.simplegame.core.data.accessor.cache.IEntityCacheModelLoader;

/**
 * @author zeusgooogle@gmail.com
 * @date 2014年10月21日 下午10:00:09
 */
public interface IEntityCacheLoaderExportService {

	public void injectEntityCacheModelLoader(IEntityCacheModelLoader entityCacheModelLoader);

}
