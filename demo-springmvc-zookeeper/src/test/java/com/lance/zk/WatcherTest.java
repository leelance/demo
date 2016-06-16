package com.lance.zk;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class WatcherTest extends AbstractJUnit4SpringContextTests{
	Logger logger = LogManager.getLogger(getClass());

	@Test
	public void main() {
		String url = "10.0.2.216:2181,10.0.2.217";
		int sessionTimeout = 2000;
		try {
			ZooKeeper keeper = new ZooKeeper(url, sessionTimeout, new ZooKeeperWatcher());
			Stat stat = keeper.exists("/data/zk/data", false);
			logger.info("stat: {}", JSON.toJSONString(stat));
			
			//keeper.create("/data/zk/data", "zooTest".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
