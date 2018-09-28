package com.jeremyliao.livedatabus;

import android.arch.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/9/27 0027
 */

public class Teeeee {
    private final Map<String, MutableLiveData<Object>> bus;

    private Teeeee() {
        bus = new HashMap<>();
    }

    private static class SingletonHolder {
        private static final Teeeee DATA_BUS = new Teeeee();
    }

    public static Teeeee get() {
        return SingletonHolder.DATA_BUS;
    }

    public <T> MutableLiveData<T> getChannel(String target, Class<T> type) {
        if (!bus.containsKey(target)) {
            bus.put(target, new MutableLiveData<>());
        }
        return (MutableLiveData<T>) bus.get(target);
    }

    public MutableLiveData<Object> getChannel(String target) {
        return getChannel(target, Object.class);
    }
}
