package com.quangtrung.bindingdemo;

import android.content.Context;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;
    private Context ctx;

    public MainActivityPresenter(MainActivityContract.View view, Context ctx) {
        this.view = view;
        this.ctx = ctx;
    }

    @Override
    public void onShowData(TemperatureData temperatureData) {
        view.showData(temperatureData);
    }

}