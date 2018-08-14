package com.anjan.cleanarchitecture.presentation.model;



import java.util.List;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class StoreCoupons {

    private String store;
    private String totalCoupons ;
    private String maxCashback;
    private List<Coupon> coupons;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTotalCoupons() {
        return totalCoupons;
    }

    public void setTotalCoupons(String totalCoupons) {
        this.totalCoupons = totalCoupons;
    }

    public String getMaxCashback() {
        return maxCashback;
    }

    public void setMaxCashback(String maxCashback) {
        this.maxCashback = maxCashback;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
