package com.quangtrung.bindingdemo;

public interface MainActivityContract {
    public interface Presenter {
        void onShowData(TemperatureData temperatureData);
    }

    public interface View {
        void showData(TemperatureData temperatureData);
    }

}