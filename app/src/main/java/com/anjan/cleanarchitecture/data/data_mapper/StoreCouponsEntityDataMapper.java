package com.anjan.cleanarchitecture.data.data_mapper;

import com.anjan.cleanarchitecture.data.entity.CouponEntity;
import com.anjan.cleanarchitecture.data.entity.StoreCouponsEntity;
import com.anjan.cleanarchitecture.presentation.model.Coupon;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class StoreCouponsEntityDataMapper {

    @Inject
    public StoreCouponsEntityDataMapper() {

    }

    public StoreCoupons transform(StoreCouponsEntity storeCouponsEntity) {
        StoreCoupons storeCoupons = null;
        List<Coupon> coupons = new ArrayList<>();

        if (storeCouponsEntity != null) {
            storeCoupons = new StoreCoupons();
            storeCoupons.setStore(storeCouponsEntity.getStore());
            storeCoupons.setMaxCashback(storeCouponsEntity.getMaxCashback());
            storeCoupons.setTotalCoupons(storeCouponsEntity.getTotalCoupons());
            List<CouponEntity> couponsEntity = storeCouponsEntity.getCoupons();
            for(int i=0; i<couponsEntity.size(); i++){
                Coupon coupon = new Coupon();
                coupon.setCoupon(couponsEntity.get(i).getCoupon());
                coupon.setStore(couponsEntity.get(i).getStore());
                coupon.setCouponCode(couponsEntity.get(i).getCouponCode());
                coupon.setExpiryDate(couponsEntity.get(i).getExpiryDate());

                coupons.add(coupon);
            }

            storeCoupons.setCoupons(coupons);

        }
        return storeCoupons;
    }


    public List<StoreCoupons> transform(Collection<StoreCouponsEntity> storeCouponsEntityCollection) {
        final List<StoreCoupons> couponsList = new ArrayList<>(20);
        for (StoreCouponsEntity storeCouponsEntity : storeCouponsEntityCollection) {
            final StoreCoupons storeCoupons = transform(storeCouponsEntity);
            if (storeCoupons != null) {
                couponsList.add(storeCoupons);
            }
        }
        return couponsList;
    }
}
