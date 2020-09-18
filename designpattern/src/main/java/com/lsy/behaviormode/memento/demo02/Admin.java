package com.lsy.behaviormode.memento.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理员
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/17
 */
public class Admin {

    private int cursorIdx = 0;
    private List<ConfigMemento> mementoList = new ArrayList<ConfigMemento>();
    private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<String, ConfigMemento>();

    /**
     * 存放
     *
     * @param memento 备忘录
     */
    public void append(ConfigMemento memento) {
        mementoList.add(memento);
        mementoMap.put(memento.getConfigFile().getVersionNo(), memento);
        cursorIdx++;
    }

    /**
     * 返回、撤销
     *
     * @return 配置备忘录
     */
    public ConfigMemento undo() {
        if (--cursorIdx <= 0) {
            return mementoList.get(0);
        }
        return mementoList.get(cursorIdx);
    }

    /**
     * 恢复上一次操作
     *
     * @return 配置备忘录
     */
    public ConfigMemento redo() {
        if (++cursorIdx > mementoList.size()) {
            return mementoList.get(mementoList.size() - 1);
        }
        return mementoList.get(cursorIdx);
    }

    /**
     * 获取
     *
     * @param versionNo 版本号
     * @return 配置备忘录
     */
    public ConfigMemento get(String versionNo) {
        return mementoMap.get(versionNo);
    }

}
