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

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }


}
