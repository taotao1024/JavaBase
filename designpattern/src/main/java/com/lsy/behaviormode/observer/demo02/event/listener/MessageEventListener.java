package com.lsy.behaviormode.observer.demo02.event.listener;


import com.lsy.behaviormode.observer.demo02.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }

}