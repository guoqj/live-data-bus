package com.jeremyliao.livedatabus;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.jeremyliao.livedatabus.databinding.ActivityStickyDemoBinding;

public class StickyActivity extends AppCompatActivity {

    private ActivityStickyDemoBinding binding;
    private Observer<String> observer = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            binding.tvSticky2.setText("observeStickyForever注册的观察者收到消息: " + s);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sticky_demo);
        LiveDataBus.get()
                .with("sticky_key", String.class)
                .observeSticky(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        binding.tvSticky1.setText("observeSticky注册的观察者收到消息: " + s);
                    }
                });
        LiveDataBus.get()
                .with("sticky_key", String.class)
                .observeStickyForever(observer);
        LiveDataBus.get()
                .with("testgqj", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(StickyActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });

        binding.tvSticky2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StickyActivity.this, TestA.class));
            }
        });
        getLifecycle().addObserver(new MyLifecycleObserver());
        //test
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LiveDataBus.get()
                .with("sticky_key", String.class)
                .removeObserver(observer);
  /////////ttttttttttttttttttttttttttttttt
        System.out.println(11111111);
    }
}
