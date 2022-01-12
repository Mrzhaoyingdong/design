package com.zhaoyd6.patternface.door.util;

import java.util.*;

public class TopicRandomUtil {

    /**
     *  乱序Map元素，记录对应答案key
     *
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    public static Topic random(Map<String,String> option,String key){

        Set<String> keySet = option.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);

        Map<String,String> opionNew = new HashMap<>();

        int idx = 0;
        String keyNew = "";
        for(String next : keySet){
            String randomKey = keyList.get(idx++);
            if(key.equals(next)){
                keyNew = randomKey;
            }
            opionNew.put(randomKey,option.get(next));
        }
        return new Topic(opionNew,keyNew);
    }
}
