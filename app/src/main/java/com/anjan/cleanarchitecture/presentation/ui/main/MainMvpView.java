package com.anjan.cleanarchitecture.presentation.ui.main;

import com.anjan.cleanarchitecture.presentation.ui.base.MvpView;

/**
 * Created by Anjan Debnath on 8/10/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface MainMvpView extends MvpView{

    void showError(String error);
}
