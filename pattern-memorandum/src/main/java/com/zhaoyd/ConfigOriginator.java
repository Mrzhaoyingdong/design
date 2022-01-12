package com.zhaoyd;

/**  * All rights Reserved, Designed By zhaoyd.
 *
 * 模拟记录者
 *
 * @author: zhaoyd
 * @date: 2021/8/23 22:51
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 *
 * <p>
 *   备忘录模式是可以恢复或者说回滚，配置
 *   、版本、悔棋为核心功能的设计模式，这种设计
 *   模式属于行为模式，在功能实现上是以不破坏原对象
 *   为基础增加备忘录的操作，记录原对象的行为从而实现备忘录模式
 *
 *
 *
 */
public class ConfigOriginator {

    private ConfigFile configFile;

    public void getMemento(ConfigMemento memento){
        this.configFile = memento.getConfigFile();
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveConfigMemento(){
        return new ConfigMemento(configFile);
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }
}
