import com.zhaoyd6.patternface.door.CacheService;
import com.zhaoyd6.patternface.door.factory.JDKProxy;
import com.zhaoyd6.patternface.door.factory.impl.EGMCacheAdapter;
import com.zhaoyd6.patternface.door.factory.impl.IIRCacheAdapter;
import com.zhaoyd6.patternface.door.impl.CacheServiceImpl;
import org.junit.Test;

/**
 *  @Description: 抽象工厂
 *  @author: zhao_yd
 *  @Date: 2021/7/2 5:42 下午
 *
 */

public class APITest {


    @Test
    public void test_CacheService(){

        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "zyd");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);


        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "zyd");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);


    }
}
