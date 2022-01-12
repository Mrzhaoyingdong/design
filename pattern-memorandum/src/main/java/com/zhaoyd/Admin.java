package com.zhaoyd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  * All rights Reserved, Designed By zhaoyd.
 *
 * 模拟管理者对版本进行回滚和记录
 *
 * @author: zhaoyd
 * @date: 2021/8/23 22:59
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
public class Admin {

    private int cursorIdx = 0;
    private List<ConfigMemento> mementoList = new ArrayList<>();
    private Map<String,ConfigMemento> mementoMap = new HashMap<>();

    public void append(ConfigMemento configMemento){
        mementoList.add(configMemento);
        mementoMap.put(configMemento.getConfigFile().getVersionNo(),configMemento);
        cursorIdx++;
    }

    public ConfigMemento undo(){
        if(--cursorIdx <= 0){
            return mementoList.get(0);
        }
        return mementoList.get(cursorIdx);
    }

    public ConfigMemento redo(){
        if(++cursorIdx >mementoList.size()){
            return mementoList.get(mementoList.size()-1);
        }
        return mementoList.get(cursorIdx);
    }

    public ConfigMemento get(String versionNo){
      return mementoMap.get(versionNo);
    }
}
