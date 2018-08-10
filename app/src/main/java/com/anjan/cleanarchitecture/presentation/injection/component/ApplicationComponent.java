package com.anjan.cleanarchitecture.presentation.injection.component;

import android.app.Application;
import android.content.Context;

import com.anjan.cleanarchitecture.presentation.CleanArchitectureApplication;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;
import com.anjan.cleanarchitecture.presentation.injection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */


 /**
  * Component can be regarded as a bridge between module and dependent classes
  * Component takes the modules and then gives the dependency back to the dependent classes.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    //we explicitly declare objects available for child components (ActivityComponent here)
    Application application();

    @ApplicationContext
    Context context();

     //dependent classes that wants to communicate with modules
     void inject(CleanArchitectureApplication app);
}
