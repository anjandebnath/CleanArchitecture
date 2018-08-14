package com.anjan.cleanarchitecture.data.repository.data_source;

import android.content.Context;

import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;

import io.reactivex.Observable;


/**
 * Created by Anjan Debnath on 7/31/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class LocalDataSource implements DataSource {

//    private AppDatabase taskDb;

    public LocalDataSource(Context context){
//        taskDb = Room.databaseBuilder(context,
//                AppDatabase.class, DATABASE_NAME)
//                .build();

    }



    @Override
    public Observable<StoreCouponsEntity> getCoupons(String status) {
        return null;
    }

    @Override
    public Observable<StoreCouponsEntity> getStoreInfo() {
        return null;
    }
}
