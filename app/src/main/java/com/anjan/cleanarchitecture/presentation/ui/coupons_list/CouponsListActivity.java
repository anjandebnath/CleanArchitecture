package com.anjan.cleanarchitecture.presentation.ui.coupons_list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.anjan.cleanarchitecture.R;
import com.anjan.cleanarchitecture.data.repository.DataRepository;
import com.anjan.cleanarchitecture.presentation.model.StoreCoupons;
import com.anjan.cleanarchitecture.presentation.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anjan Debnath on 8/13/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class CouponsListActivity extends BaseActivity implements CouponsListMvpView {

    @Inject
    CouponsListPresenter userListPresenter;


    @BindView(R.id.recyclerView_users)
    RecyclerView couponRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.button_retry)
    Button buttonRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        //set layout manager for recyclerView
        RecyclerView.LayoutManager couponLayoutManager = new LinearLayoutManager(this);
        couponRecyclerView.setLayoutManager(couponLayoutManager);

        userListPresenter.attachView(this);

        userListPresenter.getCouponData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        userListPresenter.detachView();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetryButton() {
         buttonRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetryButton() {
        buttonRetry.setVisibility(View.GONE);
    }



    @Override
    public void showError() {

    }

    @Override
    public void showCoupons(StoreCoupons storeCoupons) {
        if(storeCoupons.getCoupons() != null){
            CouponsAdapter ca = new CouponsAdapter(storeCoupons.getCoupons(), CouponsListActivity.this);
            couponRecyclerView.setAdapter(ca);
        }
    }
}
