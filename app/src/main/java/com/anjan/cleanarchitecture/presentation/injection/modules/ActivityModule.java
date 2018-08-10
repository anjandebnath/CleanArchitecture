package com.anjan.cleanarchitecture.presentation.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ActivityContext;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity(){
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext(){
        return activity;
    }

}
