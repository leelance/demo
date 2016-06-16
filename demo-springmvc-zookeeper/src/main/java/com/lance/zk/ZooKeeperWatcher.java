package com.lance.zk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import com.alibaba.fastjson.JSON;

public class ZooKeeperWatcher implements Watcher {
	Logger logger = LogManager.getLogger(getClass());

	@Override
	public void process(WatchedEvent event) {
		logger.info("EventType: {}", event.getType());
		logger.info("WatchedEvent: {}", JSON.toJSONString(event));
	}
}