package com.anjan.cleanarchitecture.presentation.repository.data_source;

import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;

import io.reactivex.Observable;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface StoreCouponDataSource {

    Observable<StoreCoupons> getCoupons(String status);
    Observable<StoreCoupons> getStoreInfo();
}
