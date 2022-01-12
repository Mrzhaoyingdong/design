import com.alibaba.fastjson.JSON;
import com.zhaoyd.Activity;
import com.zhaoyd.ActivityController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @Description: 单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/5 8:25 下午
 *
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private ActivityController activityController = new ActivityController();

    @Test
    public void test_queryActivityInfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.get(req);
            logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
    }

}
