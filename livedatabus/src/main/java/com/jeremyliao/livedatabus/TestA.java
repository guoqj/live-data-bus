package com.jeremyliao.livedatabus;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TestA extends AppCompatActivity {

    private NameViewModel mModel;
    TextView textView;
    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        textView = findViewById(R.id.test);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotherName = "John Doe";
                // mModel.getCurrentName().setValue(anotherName);
//                Teeeee.get().getChannel("ddd").setValue("rrrrdddd");
//                test.getCurrentName().setValue("ddddddddd");
                ITest test = TypeDemo.create(ITest.class);
                System.out.println(test.getTest(90, 30).toStirng());
                System.out.println(test.getTestsss(90).toStirng());
            }
        });
        test = new Test();
        test.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                System.out.println("s===============>" + s);
            }
        });
        // Other code to setup the activity...
        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                textView.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);
        TypeDemo.test("dddd");

        Teeeee.get().getChannel("ddd", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
