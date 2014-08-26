package com.ejbexample5.ejbmanager.jsonUtil;

import javax.ejb.Local;

/**
 * Created by Вадим on 25.08.2014.
 */
@Local
public interface JsonUtil {
    <T>  T fromJson(String s, Class<T> classOfT);

    String toJson(Object o);
}
