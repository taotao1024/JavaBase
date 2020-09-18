package com.lsy.behaviormode.observer.demo02;

import com.lsy.behaviormode.observer.demo00.MinibusTargetService;

import java.util.Date;

/**
 * TODO
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public class LotteryServiceImpl extends BaseLotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }

}
