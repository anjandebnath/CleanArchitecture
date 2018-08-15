package com.anjan.cleanarchitecture.data.data_mapper;

import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;

import java.util.Collection;
import java.util.List;

/**
 * Created by Anjan Debnath on 8/15/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface EntityDataMapper {

    StoreCoupons transform(StoreCouponsEntity storeCouponsEntity);

    List<StoreCoupons> transform(Collection<StoreCouponsEntity> storeCouponsEntityCollection);
}
