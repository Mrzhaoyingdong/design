import com.zhaoyd.MainConfig;

import com.zhaoyd.mapper.TestYY;
import com.zhaoyd.mapper.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *  @Description: 单元测试
 *  @author: zhao_yd
 *  @Date: 2021/8/6 2:36 下午
 *
 */

public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();


        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).stream().forEach(s -> {
            System.out.println(s);
        });

        UserDao userDao = (UserDao) context.getBean("userDao");
        String s = userDao.queryUserInfo("10001");
        log.info("获取测试结果:{}",s);

    }
}
