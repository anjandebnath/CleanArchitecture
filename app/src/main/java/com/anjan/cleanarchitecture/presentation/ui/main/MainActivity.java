package com.anjan.cleanarchitecture.presentation.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.anjan.cleanarchitecture.R;
import com.anjan.cleanarchitecture.presentation.ui.base.BaseActivity;
import com.anjan.cleanarchitecture.presentation.ui.coupons_list.CouponsListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @BindView(R.id.button_load_data)
    Button btnLoadData;

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

    @OnClick(R.id.button_load_data)
    void navigateToUserList(){
        Intent intent = new Intent(MainActivity.this, CouponsListActivity.class);
        startActivity(intent);
    }
}
