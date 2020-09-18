package com.lsy.behaviormode.observer.demo02.event.listener;


import com.lsy.behaviormode.observer.demo02.LotteryResult;

/**
 * TODO
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public interface EventListener {
    /**
     * TODO
     *
     * @param result 抽象对象
     */
    void doEvent(LotteryResult result);

}
