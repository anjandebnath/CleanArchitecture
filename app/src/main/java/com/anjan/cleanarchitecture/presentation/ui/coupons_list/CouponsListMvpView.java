package com.anjan.cleanarchitecture.presentation.ui.coupons_list;

import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;
import com.anjan.cleanarchitecture.presentation.ui.base.MvpView;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface CouponsListMvpView extends MvpView {

    void showLoading();

    void hideLoading();

    void showRetryButton();

    void hideRetryButton();

    void showError();

    void showCoupons(StoreCoupons storeCoupons);
}
