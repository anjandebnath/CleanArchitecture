package com.anjan.cleanarchitecture.presentation.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anjan.cleanarchitecture.R;
import com.anjan.cleanarchitecture.presentation.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPresenter.attachView(this);
        mMainPresenter.doSomething();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMainPresenter.detachView();
    }

    @Override
    public void showError(String error) {

    }
}
