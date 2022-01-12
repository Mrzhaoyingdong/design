package com.zhaoyd;
/**
 *
 * <p>
 * 观察者设计模式
 * 观察者设计模式主要是解决让主线服务与其他
 * 辅线业务服务分离，为了使系统降低耦合性和增强
 * 扩展性。
 *
 *  @Description: 模拟摇号
 *  @author: zhao_yd
 *  @Date: 2021/8/25 11:18 上午
 *
 */

public class MinibusTargetService {

    public String lottery(String uid){
        return Math.abs(uid.hashCode()) % 2 == 0 ?
                "恭喜你，编码".concat(uid).concat("摇中签") :
                "很遗憾，编码".concat(uid).concat("在本次摇号未中签货摇号资格已过期");
    }

}
