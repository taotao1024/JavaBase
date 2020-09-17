package com.lsy.behaviormode.mediator.demo02.mediator;

import java.sql.Connection;
import java.util.Map;


/**
 * SqlSessionFactory需要的配置文件
 *
 * @author TT
 */
public class Configuration {

    protected Connection connection;
    protected Map<String, String> dataSource;
    protected Map<String, XNode> mapperElement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }

    public Connection getConnection() {
        return connection;
    }

    public Map<String, String> getDataSource() {
        return dataSource;
    }

    public Map<String, XNode> getMapperElement() {
        return mapperElement;
    }

}
