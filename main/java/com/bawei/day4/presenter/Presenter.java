package com.bawei.day4.presenter;

import com.bawei.day4.base.BasePresenter;
import com.bawei.day4.contract.Contract;
import com.bawei.day4.model.Modle;

public class Presenter extends BasePresenter {
    private Contract.IModel model;
    @Override
    protected void initModel() {
        model=new Modle();
    }

    @Override
    public void start(String url) {
        model.getInfo(url, new Contract.Mycallback() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Error(String error) {
                getView().Error(error);
            }
        });
    }
}
