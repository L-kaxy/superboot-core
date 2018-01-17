/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.po;

import org.apache.commons.beanutils.BeanMap;

import com.wteam.superboot.core.helper.JsonHelper;

/**
 * 持久对象超类,实体的共用方法.
 * 
 */
public class SuperPersistentObject {

    /**
     * 2的5次方.
     */
    private static final int TWO_TO_THE_POWER_OF_FIVE = 31;

    /**
     * 返回此实体的哈希码。实体对象的哈希码根据以下公式计算. s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * 使用 int 算法，这里 s[i] 是实体的第 i个成员变量的哈希吗，n是成员变量总数，^ 表示求幂。（空实体的哈希值为 0。）
     * 
     * @return 此对象的哈希码值.
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    @Override
    public final int hashCode() {
        int h = 0;
        BeanMap beanMap = new BeanMap(this);
        for (Object value : beanMap.values()) {
            if (value != null) {
                h = TWO_TO_THE_POWER_OF_FIVE * h + value.hashCode();
            }
        }
        return h;
    }

    /**
     * 将此实体与指定的对象比较. 当且仅当该参数不为 null,并且是与此对象成员变量相同的实体对象时,结果才为 true.
     * 
     * @param other
     *            与此实体进行比较的对象。
     * 
     * @return true 给定对象表示的实体与本实体相等 false 给定对象表示的实体与本实体不相等
     * 
     * @author 侯骏雄
     * @since 3.0.0
     */
    @Override
    public final boolean equals(final Object other) {
        boolean result = true;
        result = this.getClass().isInstance(other);

        if (result) {
            BeanMap beanMap = new BeanMap(this);
            BeanMap otherBeanMap = new BeanMap(other);
            Object val = null;
            Object otherVal = null;
            for (Object key : beanMap.keySet()) {
                val = beanMap.get(key);
                otherVal = otherBeanMap.get(key);

                if (val != null && otherVal != null) {
                    result = beanMap.get(key).equals(otherBeanMap.get(key));
                } else if (val == null && otherVal == null) {
                    result = true;
                } else {
                    result = false;
                }

                if (!result) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 打印该对象的成员变量，以便于调试.
     * 
     * @return 该对象的成员变量字符串信息.
     * 
     * @author 侯骏雄
     * @since 5.0.0
     */
    @Override
    public String toString() {
        String result = super.toString() + " " + JsonHelper.toJson(this);
        return result;
    }
}
