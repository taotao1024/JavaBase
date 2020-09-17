package com.lsy.behaviormode.mediator.demo02.mediator;

import com.lsy.behaviormode.mediator.demo02.mediator.impl.DefaultSqlSessionFactory;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SqlSessionFactoryBuilder 构建者(简化了对象的创建)
 * <p>
 * 处理工厂、解析文件、拿到Session等功能
 *
 * @author TT
 */
public class SqlSessionFactoryBuilder {
    /**
     * 创建解析XML文件的类、初始化SqlSessionFactory工厂
     *
     * @param reader
     * @return
     */
    public DefaultSqlSessionFactory build(Reader reader) {
        /**
         * SAX解析器
         */
        SAXReader saxReader = new SAXReader();
        try {
            // 设置解析器
            // 保证在不联网的情况下解析XML,否则会从互联网获取DTD文件。
            saxReader.setEntityResolver(new XMLMapperEntityResolver());
            // 获取DOM结构
            Document document = saxReader.read(new InputSource(reader));
            // 解析根节点
            Configuration configuration = this.parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析配置
     * <p>
     * 对XML文件进行读取，主要获取dataSource、mappers
     *
     * @param root 元素
     * @return 配置文件
     */
    private Configuration parseConfiguration(Element root) {
        Configuration configuration = new Configuration();
        // 数据库连接信息
        configuration.setDataSource(this.dataSource(root.selectNodes("//dataSource")));
        // 获取连接
        configuration.setConnection(this.connection(configuration.dataSource));
        // 数据库操作语句解析
        configuration.setMapperElement(this.mapperElement(root.selectNodes("mappers")));
        return configuration;
    }

    /**
     * 获取数据源配置信息
     *
     * @param list list对象
     * @return 数据源配置信息
     */
    private Map<String, String> dataSource(List<Element> list) {
        Map<String, String> dataSource = new HashMap<>(4);
        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    /**
     * 链接数据库
     *
     * @param dataSource 数据源
     * @return Connection
     */
    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"), dataSource.get("username"), dataSource.get("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析SQL语句信息
     *
     * @param list list对象
     * @return 数据源配置信息
     */
    private Map<String, XNode> mapperElement(List<Element> list) {
        Map<String, XNode> map = new HashMap<>();

        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String resource = e.attributeValue("resource");

            try {
                Reader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element root = document.getRootElement();
                //命名空间
                String namespace = root.attributeValue("namespace");

                // SELECT
                List<Element> selectNodes = root.selectNodes("select");
                for (Element node : selectNodes) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    // ? 匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for (int i = 1; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);
                    xNode.setParameter(parameter);

                    map.put(namespace + "." + id, xNode);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return map;
    }

}
