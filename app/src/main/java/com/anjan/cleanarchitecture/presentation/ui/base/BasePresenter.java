package com.anjan.cleanarchitecture.presentation.ui.base;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public abstract class BasePresenter<V extends MvpView> implements Presenter<V> {

    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    /**
     * get MVP view of the Activity
     * @return
     */
    public V getMvpView() {
        return mMvpView;
    }


    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    @Override
    public void onPresenterDestroy() {

    }

    @Override
    public void onPresenterCreated() {

    }
}

