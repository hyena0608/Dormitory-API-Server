package com.example.dormi.controller.util;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
public class Converter {

    public static <T> Object convert(Object obj, Type type) {

        if (obj == null) return null;
        if (type == null) return null;

        ParameterizedType arrayListWithParamType = (ParameterizedType) type.getClass().getGenericSuperclass();
        Type integerType = arrayListWithParamType.getActualTypeArguments()[0];

        Class<?> clazz = null;
        if (type instanceof Class) {
            clazz = (Class<?>) type;
        }

        if (null == clazz) return null;

        Gson gson = new Gson();
        String s = gson.toJson(obj);

        Constructor<?> constructor = null;
        Object targetObject = null;
        try {
            constructor = clazz.getConstructor();
            targetObject = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        targetObject = gson.fromJson(s, clazz);
        if (null != targetObject) {
            return clazz.cast(targetObject);
        } else {
            return null;
        }

    }

    public static <T> T convert(Object obj, Class<T> clazz) {

        if (obj == null) return null;
        if (clazz == null) return null;

        Gson gson = new Gson();
        String s = gson.toJson(obj);

        Constructor<?> constructor = null;
        Object targetObject = null;
        try {
            constructor = clazz.getConstructor();
            targetObject = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        targetObject = gson.fromJson(s, clazz);
        if (null != targetObject) {
            return clazz.cast(targetObject);
        } else {
            return null;
        }
    }
}
