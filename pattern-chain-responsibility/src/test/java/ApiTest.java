import com.alibaba.fastjson.JSON;

import com.zhaoyd.auth.AuthService;
import com.zhaoyd.auth.link.AuthLink;
import com.zhaoyd.auth.link.impl.Level1AuthLink;
import com.zhaoyd.auth.link.impl.Level2AuthLink;
import com.zhaoyd.auth.link.impl.Level3AuthLink;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "峰哥")
                .appendNext(new Level2AuthLink("1000012", "姚哥")
                        .appendNext(new Level1AuthLink("1000011", "金总")));

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date date = df.parse("6-12-2011");

        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("赵英东", "1000998004813441", date)));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("赵英东", "1000998004813441", date)));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("赵英东", "1000998004813441", date)));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("赵英东", "1000998004813441", date)));

    }

}
