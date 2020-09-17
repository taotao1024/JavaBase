package com.lsy.createdmode.prototypemode.demo02.util;

import java.util.*;

/**
 * 随机工具
 *
 * @author TT
 */
public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     *
     * @param option 选项
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        // 创建一个set对象
        Set<String> keySet = option.keySet();
        // list用来存储map的value
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        // 洗牌
        Collections.shuffle(keyList);
        // 新的HashMap
        HashMap<String, String> optionNew = new HashMap<String, String>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}
