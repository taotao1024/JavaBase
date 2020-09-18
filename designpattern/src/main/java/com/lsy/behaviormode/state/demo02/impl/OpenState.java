package com.lsy.behaviormode.state.demo02.impl;

import com.lsy.behaviormode.state.demo00.ActivityService;
import com.lsy.behaviormode.state.demo00.Status;
import com.lsy.behaviormode.state.demo02.Result;
import com.lsy.behaviormode.state.demo02.BaseState;

/**
 * 活动状态；活动开启
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class OpenState extends BaseState {

    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核通过");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可撤销审核");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭完成");
    }

    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动不可重复开启");
    }

    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "活动变更活动中完成");
    }

}