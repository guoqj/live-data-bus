package com.jeremyliao.livedatabus;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/9/28 0028
 */

public class MyLifecycleObserver  implements GenericLifecycleObserver {

    private static final String TAG = MyLifecycleObserver.class.getSimpleName();

    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        ;
        System.out.println(source.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.DESTROYED));
        System.out.println(source.getLifecycle().getCurrentState()+"-------------------");
    }
}
