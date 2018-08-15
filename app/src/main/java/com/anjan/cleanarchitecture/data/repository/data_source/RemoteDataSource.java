package com.anjan.cleanarchitecture.data.repository.data_source;

import android.content.Context;

import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;
import com.anjan.cleanarchitecture.data.remote_service.RemoteApi;
import com.anjan.cleanarchitecture.data.remote_service.RemoteService;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class RemoteDataSource implements DataSource {

    private Retrofit retrofit;

    @Inject
    public RemoteDataSource(@ApplicationContext Context context){
        retrofit = RemoteService.getRemoteApiClient();
    }

    @Override
    public Observable<StoreCouponsEntity> getCoupons(String status) {
        return retrofit.create(RemoteApi.class).getCoupons(status);
    }

    @Override
    public Observable<StoreCouponsEntity> getStoreInfo() {
        return null;
    }
}
