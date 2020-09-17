package com.lsy.behaviormode.memento.demo02;

/**
 * 配置备忘录
 * <p>
 * 对原有配置的扩展
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/17
 */
public class ConfigMemento {
    /**
     * 构造函数
     *
     * @param configFile 配置文件
     */
    public ConfigMemento(ConfigFile configFile) {
        this.configFile = configFile;
    }

    /**
     * 组合
     */
    private ConfigFile configFile;


    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

}
