package com.lsy.config.zkconfig;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YY
 */
public class Config {
    /**
     * 前缀
     */
    private static final String CONFIG_PREFIX = "/zkConfig";

    private CuratorFramework client;
    private Map<String, String> cache = new HashMap<>();

    public Config(String address) {
        client = CuratorFrameworkFactory.newClient(address, new RetryNTimes(3, 1000));
        client.start();
        init();
    }

    public void init() {
        try {
            List<String> childrenNames = client.getChildren().forPath(CONFIG_PREFIX);
            for (String name : childrenNames) {
                String value = new String(client.getData().forPath(getConfigFullName(name)));
                cache.put(name, value);
            }

            // 绑定一个监听器
            // 添加 删除 修改
            PathChildrenCache watcher = new PathChildrenCache(client, CONFIG_PREFIX, true);

            watcher.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                    String path = event.getData().getPath();
                    System.out.println(event);

                    if (path.startsWith(CONFIG_PREFIX)) {
                        String key = path.replace(CONFIG_PREFIX + "/", "");
                        if (PathChildrenCacheEvent.Type.CHILD_ADDED.equals(event.getType()) ||
                                PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(event.getType())) {
                            String value = new String(event.getData().getData());
                            cache.put(key, value);

                        } else if (PathChildrenCacheEvent.Type.CHILD_REMOVED.equals(event.getType())) {
                            cache.remove(key);
                        }
                    }
                }
            });

            watcher.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // 新增或更新配置，一个配置项对应一个zookeeper节点，节点内容为配置项值
    public void save(String name, String value) {
        try {
            String configFullName = getConfigFullName(name);
            Stat stat = client.checkExists().forPath(configFullName);
            if (stat != null) {
                // update
                client.setData().forPath(configFullName, value.getBytes());
            } else {
                // create
                client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(configFullName, value.getBytes());
            }

            cache.put(name, value);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getConfigFullName(String name) {
        return CONFIG_PREFIX + "/" + name;
    }

    public String get(String name) {
        return cache.get(name);
    }
}
