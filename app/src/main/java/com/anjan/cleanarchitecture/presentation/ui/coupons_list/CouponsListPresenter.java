package com.anjan.cleanarchitecture.presentation.ui.coupons_list;

import android.content.Context;

import com.anjan.cleanarchitecture.data.repository.DataRepository;
import com.anjan.cleanarchitecture.presentation.injection.custom_scope.ApplicationContext;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;
import com.anjan.cleanarchitecture.presentation.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class CouponsListPresenter extends BasePresenter<CouponsListMvpView> {

    DataRepository dataRepository;

    @Inject
    public CouponsListPresenter(@ApplicationContext Context context, DataRepository repository) {
        dataRepository = repository;
    }

    //single api call using retrofit and rxjava
    public void getCouponData(){

        getMvpView().showLoading();
        dataRepository.getCoupons("topcoupons")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);

    }



    //two Retrofit service calls execute parallel using RxJava
    /*public void getStoreCouponData(){

        Observable.just(RemoteService.getRemoteApiClient().create(RemoteApi.class))
                .subscribeOn(Schedulers.computation())
                .flatMap(s -> {

                    Observable<StoreCoupons> couponsObservable
                            = s.getCoupons("topcoupons")
                            .subscribeOn(Schedulers.io());

                    Observable<StoreCoupons> storeInfoObservable
                            = s.getStoreInfo()
                            .subscribeOn(Schedulers.io());

                    return Observable.concatArray(couponsObservable, storeInfoObservable);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);


    }*/

    private void handleResults(StoreCoupons storeCoupons){
        if(getMvpView()!= null){
            getMvpView().hideLoading();
            getMvpView().showCoupons(storeCoupons);
        }
    }

    private void handleError(Throwable t){
        if(getMvpView()!= null){
            getMvpView().hideLoading();
            getMvpView().showError();
        }
    }
}
