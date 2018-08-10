package com.anjan.cleanarchitecture.presentation.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.anjan.cleanarchitecture.presentation.CleanArchitectureApplication;
import com.anjan.cleanarchitecture.presentation.injection.component.ActivityComponent;
import com.anjan.cleanarchitecture.presentation.injection.component.ApplicationComponent;
import com.anjan.cleanarchitecture.presentation.injection.component.DaggerActivityComponent;
import com.anjan.cleanarchitecture.presentation.injection.modules.ActivityModule;


/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private ActivityComponent mActivityComponent;

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = buildActivityComponent();


    }

    public ActivityComponent buildActivityComponent(){

        CleanArchitectureApplication application = (CleanArchitectureApplication) getApplication();
        ApplicationComponent applicationComponent = application.getApplicationComponent();


        return DaggerActivityComponent.builder()
                // the module will be initialized
                .activityModule(new ActivityModule(this))
                // dependent on ApplicationComponent
                .applicationComponent(applicationComponent)
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
