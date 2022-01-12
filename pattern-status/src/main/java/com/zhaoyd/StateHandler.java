package com.zhaoyd;

import com.zhaoyd.base.Status;
import com.zhaoyd.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 状态模式
 * 状态模式描述的是一个行为下的多种状态变更，
 * 比如我们最常见的一个网站的页面，在你登陆与不登陆
 * 就是我们通过改变状态，而让整个行为发生了变化
 *
 *
 *  @Description: 状态处理器
 *  @author: zhao_yd
 *  @Date: 2021/8/25 4:37 下午
 *
 */


public class StateHandler {


    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateHandler() {
        stateMap.put(Status.Check, new CheckState());     // 待审核
        stateMap.put(Status.Close, new CloseState());     // 已关闭
        stateMap.put(Status.Doing, new DoingState());     // 活动中
        stateMap.put(Status.Editing, new EditingState()); // 编辑中
        stateMap.put(Status.Open, new OpenState());       // 已开启
        stateMap.put(Status.Pass, new PassState());       // 审核通过
        stateMap.put(Status.Refuse, new RefuseState());   // 审核拒绝
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
