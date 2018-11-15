package com.jeremyliao.livedatabus;

import java.util.List;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/9/30 0030
 */

public class CallBack {

    List<String> lists;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public String toStirng() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : lists) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
