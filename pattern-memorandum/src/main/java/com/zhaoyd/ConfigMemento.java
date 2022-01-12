package com.zhaoyd;
/**  * All rights Reserved, Designed By zhaoyd.
 *
 * 备忘录类
 *
 * @author: zhaoyd
 * @date: 2021/8/23 22:42
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
public class ConfigMemento {

    private ConfigFile configFile;

    public ConfigMemento(ConfigFile configFile){
        this.configFile = configFile;
    }


    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }
}
