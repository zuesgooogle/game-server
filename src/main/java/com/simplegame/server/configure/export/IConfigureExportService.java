package com.simplegame.server.configure.export;

import java.util.List;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;

public interface IConfigureExportService {
    
    public void add(IEntity entity);

    public void deleteById(Class<? extends IEntity> entity, Object id);

    public void deleteAll(Class<? extends IEntity> entity);

    public <T extends IEntity> T get(Class<? extends IEntity> entity, Object id);

    public <T extends IEntity> List<T> get(Class<? extends IEntity> entity);

    public <T extends IEntity> List<T> getByFilter(Class<? extends IEntity> entity, IQueryFilter<IEntity> queryFilter);
}

