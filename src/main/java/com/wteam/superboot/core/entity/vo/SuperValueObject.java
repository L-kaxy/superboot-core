/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanMap;

import com.wteam.superboot.core.entity.po.SuperPersistentObject;
import com.wteam.superboot.core.helper.JsonHelper;
import com.wteam.superboot.core.helper.NullHelper;

/**
 * 值对象超类,该类提供了一些值对象共用的方法.
 * 
 */
public class SuperValueObject extends SuperPersistentObject {

    /**
     * 返回转换后的参数.
     * 
     * @param obj
     *            成员变量
     * @param castClass
     *            转换类型
     * @return 指定类型参数
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    private static Object castVoParam(final Object obj, final Class<?> castClass) {
        Object castParm = null;
        try {
            if ("null".equals(obj)) {
                castParm = NullHelper.getNullObject(castClass);
            } else {
                if (castClass.isAssignableFrom(Timestamp.class)) {
                    final Date date = new SimpleDateFormat(
                            "yyyy-MM-dd HH:mm:ss").parse(String.valueOf(obj));
                    castParm = new Timestamp(date.getTime());
                } else if (castClass.isAssignableFrom(String.class)) {
                    castParm = obj;
                } else {
                    castParm = castClass.getMethod("valueOf", String.class)
                            .invoke(castClass, obj.toString());
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return castParm;
    }

    /**
     * 返回转换后的参数.
     * 
     * @param obj
     *            成员变量
     * @return string类型参数
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    private static Object castPoParam(final Object obj) {
        Object castParm = null;
        try {
            final Class<?> objClass = obj.getClass();
            if (objClass.isAssignableFrom(Timestamp.class)) {
                castParm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(obj);
            } else if (objClass.isAssignableFrom(String.class)) {
                castParm = obj;
            } else {
                castParm = String.valueOf(obj);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return castParm;
    }

    /**
     * 将值对象转换为持久对象.
     * 
     * @param poClass
     *            持久类对象
     * @param <T>
     *            持久类对象类型
     * @return 转换后的持久对象.
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    public final <T> T voToPo(final Class<T> poClass) {
        T poObj = null;
        try {
            final BeanMap voMap = new BeanMap(this);
            final List<?> tempList = new ArrayList<Object>(voMap.values());
            boolean hasNull = true;
            do {
                hasNull = tempList.remove(null);
            } while (hasNull);

            // 默认有一个代表本对象类型的class成员变量
            if (tempList.size() > 0) {
                poObj = poClass.newInstance();
                final BeanMap poMap = new BeanMap(poObj);
                Object value = null;
                String keyName = null;
                for (final Object key : voMap.keySet()) {
                    value = voMap.get(key);
                    keyName = key.toString();
                    if (value != null
                            && !value.getClass().isAssignableFrom(Class.class)
                            && !"".equals(value)) {
                        poMap.getWriteMethod(keyName).invoke(poObj,
                                castVoParam(value, poMap.getType(keyName)));
                    }
                }
            }
        } catch (final Exception e1) {
            e1.printStackTrace();
        }
        return poObj;
    }

    /**
     * 持久层对象转换为值对象.
     * 
     * @param po
     *            数据持久层对象.
     * @param <T>
     *            数据持久层对象类型.
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    public final <T> void poToVo(final T po) {
        try {
            final BeanMap voMap = new BeanMap(this);
            final BeanMap poMap = new BeanMap(po);
            Object value = null;
            String keyName = null;
            for (final Object key : poMap.keySet()) {
                value = poMap.get(key);
                keyName = key.toString();
                if (value != null
                        && !value.getClass().isAssignableFrom(Class.class)) {
                    voMap.getWriteMethod(keyName).invoke(this,
                            castPoParam(value));
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * json字符串转换为持久层对象.
     * 
     * @param json
     *            json字符串.
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    public final void jsonToVo(final String json) {
        try {
            final Class<?> beanClass = this.getClass();

            final Object bean = JsonHelper.jsonToBean(json, beanClass);

            final BeanMap voMap = new BeanMap(this);
            final BeanMap beanMap = new BeanMap(bean);
            Object value = null;
            String keyName = null;
            for (final Object key : beanMap.keySet()) {
                value = beanMap.get(key);
                keyName = key.toString();
                if (value != null
                        && !value.getClass().isAssignableFrom(Class.class)
                        && !"".equals(value)) {
                    voMap.getWriteMethod(keyName).invoke(this,
                            castPoParam(value));
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
