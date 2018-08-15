package com.anjan.cleanarchitecture.data.repository;

import android.content.Context;
import android.util.Log;

import com.anjan.cleanarchitecture.data.data_mapper.EntityDataMapper;
import com.anjan.cleanarchitecture.data.repository.data_source.DataSource;
import com.anjan.cleanarchitecture.data.repository.data_source.LocalDataSource;
import com.anjan.cleanarchitecture.data.repository.data_source.RemoteDataSource;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;
import com.anjan.cleanarchitecture.presentation.repository.data_source.StoreCouponDataSource;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Anjan Debnath on 7/31/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */


public class DataRepository implements StoreCouponDataSource {


    private DataSource mLocalDataSource;
    private DataSource mRemoteDataSource;

    EntityDataMapper entityDataMapper;

    @Inject
    public DataRepository(EntityDataMapper entityDataMapper, @ApplicationContext Context context
                          ) {
        this.entityDataMapper = entityDataMapper;
        this.mLocalDataSource = new LocalDataSource(context);
        this.mRemoteDataSource = new RemoteDataSource(context);
    }



    @Override
    public Observable<StoreCoupons> getCoupons(String status) {
        if(mRemoteDataSource!= null){
            Log.e("DataSource", "not null");
            if(entityDataMapper!= null){
                Log.e("Mapper", "not null");
                return  mRemoteDataSource.getCoupons(status).map(this.entityDataMapper::transform);
            }

        }
      return null;
    }

    @Override
    public Observable<StoreCoupons> getStoreInfo() {
        return null;
    }
}
