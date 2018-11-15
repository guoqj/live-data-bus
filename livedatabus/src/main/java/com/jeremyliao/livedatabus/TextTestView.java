package com.jeremyliao.livedatabus;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/13 0013
 */

public class TextTestView extends android.support.v7.widget.AppCompatButton {

    public TextTestView(Context context) {
        super(context);
    }

    public TextTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("TextTestView======onTouchEvent");
        return true;
    }
}
