package com.anjan.cleanarchitecture.data.repository.data_source;


import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;

import io.reactivex.Observable;

/**
 * Created by Anjan Debnath on 7/31/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface DataSource {

    Observable<StoreCouponsEntity> getCoupons(String status);
    Observable<StoreCouponsEntity> getStoreInfo();


}
