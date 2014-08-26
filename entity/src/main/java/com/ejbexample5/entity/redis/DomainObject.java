package com.ejbexample5.entity.redis;

import java.io.Serializable;

/**
 * Created by Вадим on 26.08.2014.
 */
public interface DomainObject extends Serializable {

    String getKey();

    String getObjectKey();
}

