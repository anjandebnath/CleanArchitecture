package com.anjan.cleanarchitecture.presentation;

import android.app.Application;

import com.anjan.cleanarchitecture.presentation.injection.component.ApplicationComponent;
import com.anjan.cleanarchitecture.presentation.injection.component.DaggerApplicationComponent;
import com.anjan.cleanarchitecture.presentation.injection.modules.ApplicationModule;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class CleanArchitectureApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = buildApplicationComponent();
        //this CleanArchitectureApplication class consist all provided objects via component
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent buildApplicationComponent(){
        //Here all the module class should be initialized
        // to build the whole dependency graph.
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


}
