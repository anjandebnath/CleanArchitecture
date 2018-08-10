package com.anjan.cleanarchitecture.presentation.injection.modules;

import android.app.Application;
import android.content.Context;

import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.DatabaseInfo;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.PreferenceInfo;
import com.anjan.cleanarchitecture.presentation.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

@Module
public class ApplicationModule {

    Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName(){
        return AppConstants.PREF_NAME;
    }
}
