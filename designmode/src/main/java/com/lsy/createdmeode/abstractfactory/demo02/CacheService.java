package com.lsy.createdmeode.abstractfactory.demo02;

import java.util.concurrent.TimeUnit;

/**
 * @author TT
 */
public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
