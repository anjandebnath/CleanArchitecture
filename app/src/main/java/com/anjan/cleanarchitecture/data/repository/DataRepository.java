package com.anjan.cleanarchitecture.data.repository;

import android.content.Context;

import com.anjan.cleanarchitecture.data.data_mapper.StoreCouponsEntityDataMapper;
import com.anjan.cleanarchitecture.data.repository.data_source.DataSource;
import com.anjan.cleanarchitecture.data.repository.data_source.LocalDataSource;
import com.anjan.cleanarchitecture.data.repository.data_source.RemoteDataSource;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;
import com.anjan.cleanarchitecture.presentation.repository.data_source.StoreCouponDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Anjan Debnath on 7/31/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */


public class DataRepository implements StoreCouponDataSource {


    private DataSource mTasksLocalDataSource;
    private DataSource mTasksRemoteDataSource;

    @Inject
    StoreCouponsEntityDataMapper storeCouponsEntityDataMapper;


    @Inject
    public DataRepository(@ApplicationContext Context context) {
        mTasksLocalDataSource = new LocalDataSource(context);
        mTasksRemoteDataSource = new RemoteDataSource(context);
    }



    @Override
    public Observable<StoreCoupons> getCoupons(String status) {
       return  mTasksRemoteDataSource.getCoupons(status).map(this.storeCouponsEntityDataMapper::transform);
    }

    @Override
    public Observable<StoreCoupons> getStoreInfo() {
        return null;
    }
}
