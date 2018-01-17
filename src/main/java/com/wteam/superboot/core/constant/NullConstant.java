/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.constant;

import java.sql.Timestamp;

/**
 * 表示各种类的null值对象的常量. 由于null本身不是对象，为了可以识别为null值进行数据库入库，特创建null常量.
 * 
 */
public final class NullConstant {

    /**
     * 私有构造方法.
     * 
     */
    private NullConstant() {
    }

    /**
     * String类null对象.
     */
    public static final String NULL_OF_STRING = new String();

    /**
     * Timestamp类null对象.
     */
    public static final Timestamp NULL_OF_TIMESTAMP = new Timestamp(
            System.currentTimeMillis());

    /**
     * Short类null对象.
     */
    public static final Short NULL_OF_SHORT = new Short(Short.MIN_VALUE);

    /**
     * Long类null对象.
     */
    public static final Long NULL_OF_LONG = new Long(Long.MIN_VALUE);

    /**
     * Integer类null对象.
     */
    public static final Integer NULL_OF_INTEGER = new Integer(Integer.MIN_VALUE);

    /**
     * Float类null对象.
     */
    public static final Float NULL_OF_FLOAT = new Float(Float.MIN_VALUE);

    /**
     * Double类null对象.
     */
    public static final Double NULL_OF_DOUBLE = new Double(Double.MIN_VALUE);
}
