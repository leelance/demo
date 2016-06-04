package com.lance.shiro.realm;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class RedisCacheManager implements CacheManager {

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return null;
	}
}
