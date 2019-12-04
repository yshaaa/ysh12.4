package com.bawei.day4.contract;

public interface Contract {

    interface IModel{
        void getInfo(String url,Mycallback mycallback);
    }
    interface IView{
        void Success(String json);
        void Error(String error);
    }
    interface IPresenter{
        void start(String url);
    }
    interface Mycallback{
        void Success(String json);
        void Error(String error);
    }
}
