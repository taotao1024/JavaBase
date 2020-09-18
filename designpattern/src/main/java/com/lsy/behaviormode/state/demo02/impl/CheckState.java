package com.lsy.behaviormode.state.demo02.impl;

import com.lsy.behaviormode.state.demo00.ActivityService;
import com.lsy.behaviormode.state.demo00.Status;
import com.lsy.behaviormode.state.demo02.Result;
import com.lsy.behaviormode.state.demo02.BaseState;

/**
 * 活动状态；待审核
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class CheckState extends BaseState {

    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Pass);
        return new Result("0000", "活动审核通过完成");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Editing);
        return new Result("0000", "活动审核撤销回到编辑中");
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
        return new Result("0001", "待审核活动不可执行活动中变更");
    }

}
