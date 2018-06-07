/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.helper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * json操作工具类.
 * 
 * @author 侯骏雄
 * @since 1.0.0
 * 
 * @version 1.2.0
 */
public final class JsonHelper {

	/**
	 * json操作工具类的私有构造方法，其作用是为了防止用户显式生成工具类的实例对象.
	 */
	private JsonHelper() {
	}

	/**
	 * 将json字符串转换为指定javabean的列表.
	 * 
	 * @param json
	 *            需要转换的json字符串
	 * @param beanClass
	 *            javabean类对象
	 * @param <T>
	 *            javabean类型
	 * @return 转换后的Javabean列表
	 */
	public static <T> List<T> jsonToBeanList(final String json, final Class<T> beanClass) {
		List<T> list = new ArrayList<T>();
		if (json != null) {
			StringBuffer jsonBuffer = new StringBuffer(json.trim());
			jsonBuffer.deleteCharAt(jsonBuffer.indexOf("["));
			jsonBuffer.deleteCharAt(jsonBuffer.lastIndexOf("]"));
			String tempJson = jsonBuffer.toString();
			if (!tempJson.trim().equals("")) {
				String[] beanJson = tempJson.split("},");
				for (String s : beanJson) {
					if (s.charAt(s.length() - 1) != '}') {
						s = s + "}";
					}
					list.add(jsonToBean(s, beanClass));
				}
			}
		}
		return list;
	}

	/**
	 * 将json字符串转换为指定javabean.
	 * 
	 * @param json
	 *            需要转换的json字符串
	 * @param beanClass
	 *            javabean类对象
	 * @param <T>
	 *            javabean类型
	 * @return 转换后的Javabean
	 */
	public static <T> T jsonToBean(final String json, final Class<T> beanClass) {
		T bean = null;
		try {
			Gson gson = new Gson();
			bean = gson.fromJson(json, beanClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * 将json字符串转换为map键值对.
	 * 
	 * @param json
	 *            需要转换的json字符串
	 * @return 将存有json内容的键值对map
	 */
	public static Map<String, Object> jsonToMap(final String json) {
		Map<String, Object> map = null;

		Gson gson = new Gson();
		TypeToken<Map<String, Object>> typeToken = new TypeToken<Map<String, Object>>() {
		};
		Type type = typeToken.getType();
		map = gson.fromJson(json, type);

		return map;
	}

	/**
	 * 将object转换为json字符串.
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return json字符串
	 */
	public static String toJson(final Object obj) {
		String json = null;

		Gson gson = new Gson();
		json = gson.toJson(obj);

		return json;
	}
}
