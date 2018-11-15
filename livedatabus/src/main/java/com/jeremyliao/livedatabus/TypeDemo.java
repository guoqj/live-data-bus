package com.jeremyliao.livedatabus;

import android.support.annotation.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/9/28 0028
 */

public class TypeDemo {


    public static <T extends String> T test(T t) {
        return t;
    }

    public <T> void func(List<T> list, T t) {
        list.add(t);
    }

    public static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, @Nullable Object[] args)
                            throws Throwable {
                        CallBack back = new CallBack();
                        List<String> lists = new ArrayList<>();
                        for (Object o : args) {
                            lists.add(o + "");
                        }
                        back.setLists(lists);
                        return back;
                    }
                });
    }
}
