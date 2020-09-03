package com.lsy.createdmeode.singlemode.demo01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 常会静态方法
 *
 * @author TT
 */
public class Singleton_00 {

    public static Map<String, String> cache = new ConcurrentHashMap<String, String>();

}
