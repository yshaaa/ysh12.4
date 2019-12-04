package com.bawei.day4.model;

import com.bawei.day4.contract.Contract;
import com.bawei.day4.util.NetUtil;

public class Modle implements Contract.IModel {
    @Override
    public void getInfo(String url, Contract.Mycallback mycallback) {
        NetUtil.getInstance().get(url, new NetUtil.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                mycallback.Success(json);
            }

            @Override
            public void onError(String error) {
                mycallback.Error(error);
            }
        });
    }
}
