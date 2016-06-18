package com.lance.zk;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
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
		String url = "192.168.100.118:2181,192.168.100.119:2181";
		int sessionTimeout = 2000;
		ZooKeeper keeper = null;
		
		try {
			keeper = new ZooKeeper(url, sessionTimeout, new ZooKeeperWatcher());
			//创建zoo
			Stat zooStat = keeper.exists("/zoo", false);
			if(zooStat == null) {
				String zooResult = keeper.create("/zoo", "zooTest".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				logger.info("stat: {}", zooResult);
			}
			
			byte[] zooByte = keeper.getData("/zoo", null, null);
			logger.info("zooByte: {}", new String(zooByte));
			
			//创建zoo/item1
			if(keeper.exists("/zoo/item1", false) == null) {
				String item1Result = keeper.create("/zoo/item1", "zoo-item1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				logger.info("item1Result: {}", item1Result);
			}
			//创建zoo/item2
			if(keeper.exists("/zoo/item2", false) == null) {
				String item2Result = keeper.create("/zoo/item2", "zoo-item2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				logger.info("item2Result: {}", item2Result);
			}
			
			List<String> children = keeper.getChildren("/zoo", false);
			logger.info("children: {}", JSON.toJSONString(children));
			
			//keeper.create("/data/zk/data", "zooTest".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			if(keeper != null) {
				try {
					keeper.close();//关闭连接
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
