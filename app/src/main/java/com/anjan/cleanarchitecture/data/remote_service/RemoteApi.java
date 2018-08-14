package com.anjan.cleanarchitecture.data.remote_service;

import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface RemoteApi {

    @GET("coupons/")
    Observable<StoreCouponsEntity> getCoupons(@Query("status") String status);
    @GET("storeOffers/")
    Observable<StoreCouponsEntity> getStoreInfo();

}
