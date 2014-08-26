package com.ejbexample5.ejbmanager.redis;


import com.ejbexample5.entity.redis.DomainObject;

import java.util.List;

/**
 * Created by Вадим on 24.08.2014.
 */

public interface Repository<V extends DomainObject> {

    void put(V obj);

    V get(String id);

    void delete(String id);

    List<V> getObjects();

}
