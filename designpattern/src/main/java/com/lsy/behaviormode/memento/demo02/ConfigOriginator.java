package com.lsy.behaviormode.memento.demo02;

/**
 * 配置记录着
 * <p>
 * 获取和返回备忘录类对象信息
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/17
 */
public class ConfigOriginator {
    /**
     * 组合
     */
    private ConfigFile configFile;

    /**
     * 备忘录
     */
    public ConfigMemento saveMemento() {
        return new ConfigMemento(configFile);
    }

    /**
     * 备忘录
     *
     * @param memento 备忘录
     */
    public void getMemento(ConfigMemento memento) {
        this.configFile = memento.getConfigFile();
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }


}
