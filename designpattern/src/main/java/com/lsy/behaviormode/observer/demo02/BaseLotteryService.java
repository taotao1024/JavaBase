package com.lsy.behaviormode.observer.demo02;


import com.lsy.behaviormode.observer.demo02.event.EventManager;
import com.lsy.behaviormode.observer.demo02.event.listener.MQEventListener;
import com.lsy.behaviormode.observer.demo02.event.listener.MessageEventListener;

/**
 * TODO
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public abstract class BaseLotteryService {

    private EventManager eventManager;

    public BaseLotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    /**
     * TODO
     *
     * @param uId UID
     * @return 实体对象
     */
    protected abstract LotteryResult doDraw(String uId);

}
