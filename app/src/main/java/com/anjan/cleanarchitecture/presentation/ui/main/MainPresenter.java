package com.anjan.cleanarchitecture.presentation.ui.main;

import android.content.Context;
import android.util.Log;

import com.anjan.cleanarchitecture.presentation.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Anjan Debnath on 8/10/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class MainPresenter extends BasePresenter<MainMvpView> {


    /**
     * Constructor injection
     */
    @Inject
    public MainPresenter() {

    }

    public void doSomething(){
        int c = 10;
        int f = 9;
        int sum = c+f;
        Log.d("Sum:", sum+"");
    }

}
