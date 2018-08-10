package com.anjan.cleanarchitecture.presentation.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.anjan.cleanarchitecture.presentation.CleanArchitectureApplication;
import com.anjan.cleanarchitecture.presentation.injection.component.ActivityComponent;
import com.anjan.cleanarchitecture.presentation.injection.component.DaggerActivityComponent;
import com.anjan.cleanarchitecture.presentation.injection.modules.ActivityModule;


/**
 * Abstract activity that every other Activity in this application must implement.
 */
public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>>
        extends AppCompatActivity implements MvpView {


    private ActivityComponent mActivityComponent;

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = buildActivityComponent();


    }

    public ActivityComponent buildActivityComponent(){
        return DaggerActivityComponent.builder()
                // the module will be initialized
                .activityModule(new ActivityModule(this))
                // dependent on ApplicationComponent
                .applicationComponent(((CleanArchitectureApplication) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
