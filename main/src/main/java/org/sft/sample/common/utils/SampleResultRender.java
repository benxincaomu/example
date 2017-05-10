package org.sft.sample.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 渲染返回值
 * @author sunft
 *
 */
public class SampleResultRender {
public static Map<String, Object> render(Object obj){
	Map<String, Object> map=new HashMap<>();
	map.put("result",obj);
	return map;
}
}
