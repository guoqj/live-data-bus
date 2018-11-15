package com.jeremyliao.livedatabus;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/13 0013
 */

public class LinerLayoutDisView extends LinearLayout {
    public LinerLayoutDisView(Context context) {
        super(context);
    }

    public LinerLayoutDisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinerLayoutDisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LinerLayoutDisView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("1111dispatchTouchEvent===================");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        System.out.println("11onInterceptTouchEvent===================");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("onTouchEvent==========");
        return super.onTouchEvent(event);
    }
}
