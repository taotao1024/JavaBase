package com.lsy.behaviormode.state.demo02.impl;

import com.lsy.behaviormode.state.demo00.ActivityService;
import com.lsy.behaviormode.state.demo00.Status;
import com.lsy.behaviormode.state.demo02.Result;
import com.lsy.behaviormode.state.demo02.BaseState;

/**
 * 活动状态；审核通过
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class PassState extends BaseState {

    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "已审核状态不可重复提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "已审核状态不可重复审核");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "审核通过不可撤销(可先拒绝审核)");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动审核关闭完成");
    }

    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "活动变更活动中完成");
    }

}
