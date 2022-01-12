import com.alibaba.fastjson.JSONObject;
import com.zhaoyd.Admin;
import com.zhaoyd.ConfigFile;
import com.zhaoyd.ConfigOriginator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

@Slf4j
public class APITest {

    @Test
    public void test() {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("1000001", "配置A" ,new Date(),"zyd"));
        admin.append(configOriginator.saveConfigMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000002", "配置B" ,new Date(),"zyd"));
        admin.append(configOriginator.saveConfigMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000003", "配置C" ,new Date(),"zyd"));
        admin.append(configOriginator.saveConfigMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000004", "配置D" ,new Date(),"zyd"));
        admin.append(configOriginator.saveConfigMemento()); // 保存配置




        //历史配置回滚
        configOriginator.getMemento(admin.undo());
        log.info("ܲ历史配置（回滚）:{}", JSONObject.toJSONString(configOriginator.getConfigFile()));

        configOriginator.getMemento(admin.undo());
        log.info("ܲ历史配置（回滚）:{}", JSONObject.toJSONString(configOriginator.getConfigFile()));


        //历史配置前进
        configOriginator.getMemento(admin.redo());
        log.info("ܲ历史配置前进：{}", JSONObject.toJSONString(configOriginator.getConfigFile()));

        //历史配置 获取
        configOriginator.getMemento(admin.get("1000002"));
        log.info("ܲ历史配置 获取：{}", JSONObject.toJSONString(configOriginator.getConfigFile()));
    }
}
