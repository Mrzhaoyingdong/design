package com.zhaoyd6.patternface.door;

/**
 *  @Description: 解答题
 *  @author: zhao_yd
 *  @Date: 2021/7/22 3:54 下午
 *
 */

public class AnswerQuestion {

    private String name;  // 问题
    private String key;   // 答案

    public AnswerQuestion() {
    }

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
