package com.ejbexample5.ejbmanager.jsonUtil.impl;

import com.ejbexample5.ejbmanager.jsonUtil.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ejb.Stateless;

@Stateless
public class JsonUtilGsonImpl implements JsonUtil {
    private Gson gson = new GsonBuilder().serializeNulls()
            .setPrettyPrinting()
            .create();

	@Override
	public <T> T fromJson(String s, Class<T> classOfT) {
		return gson.fromJson(s, classOfT);
	}

	@Override
	public String toJson(Object o) {
		return gson.toJson(o);
	}
}
