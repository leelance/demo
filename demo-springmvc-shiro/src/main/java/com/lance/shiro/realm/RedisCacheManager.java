package com.lance.shiro.realm;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheManager extends AbstractCacheManager {
	@Autowired
	private RedisTemplate<byte[], Object> redisTemplate;

	@Override
	protected Cache<byte[], Object> createCache(String name) throws CacheException {
		return new RedisCache<byte[], Object>(redisTemplate, name);
	}
}
