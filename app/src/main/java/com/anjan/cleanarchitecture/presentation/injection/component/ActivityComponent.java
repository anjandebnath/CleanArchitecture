package com.anjan.cleanarchitecture.presentation.injection.component;

import com.anjan.cleanarchitecture.presentation.injection.custom_scope.PerActivity;
import com.anjan.cleanarchitecture.presentation.injection.modules.ActivityModule;
import com.anjan.cleanarchitecture.presentation.ui.coupons_list.CouponsListActivity;
import com.anjan.cleanarchitecture.presentation.ui.main.MainActivity;


import dagger.Component;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@PerActivity  // it provides local Singleton for all activity.
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

     //dependent classes that wants to communicate with modules
     void inject(MainActivity mainActivity);

     void inject(CouponsListActivity userListActivity);
}
