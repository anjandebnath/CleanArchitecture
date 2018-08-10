package com.anjan.cleanarchitecture.presentation.injection.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ActivityContext;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.PerActivity;
import com.anjan.cleanarchitecture.presentation.ui.main.MainMvpView;
import com.anjan.cleanarchitecture.presentation.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity // its a local Singleton
    AppCompatActivity provideActivity(){
        return activity;
    }

    @Provides
    @ActivityContext // its a local Singleton
    Context provideActivityContext(){
        return activity;
    }






}
