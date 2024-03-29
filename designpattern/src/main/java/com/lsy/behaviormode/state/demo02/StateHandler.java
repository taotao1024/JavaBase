package com.lsy.behaviormode.state.demo02;


import com.lsy.behaviormode.state.demo00.Status;
import com.lsy.behaviormode.state.demo02.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/18
 */
public class StateHandler {

    private Map<Enum<Status>, BaseState> stateMap = new ConcurrentHashMap<Enum<Status>, BaseState>();

    /**
     * 构造方法
     */
    public StateHandler() {
        // 待审核
        stateMap.put(Status.Check, new CheckState());
        // 已关闭
        stateMap.put(Status.Close, new CloseState());
        // 活动中
        stateMap.put(Status.Doing, new DoingState());
        // 编辑中
        stateMap.put(Status.Editing, new EditingState());
        // 已开启
        stateMap.put(Status.Open, new OpenState());
        // 审核通过
        stateMap.put(Status.Pass, new PassState());
        // 审核拒绝
        stateMap.put(Status.Refuse, new RefuseState());
    }

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }

}
