package com.yangwei.www.presenter;

import com.yangwei.www.base.BasePresenter;
import com.yangwei.www.bean.VersionBean;
import com.yangwei.www.contract.UpdateContract;
import com.yangwei.www.net.RequestParams;
import com.yangwei.www.net.ResponseListener;
import com.yangwei.www.net.ResultData;
import com.yangwei.www.net.UrlConfig;

/**
 * Created by yangwei on 2018/5/30.
 */

public class UpdatePresenter extends BasePresenter implements UpdateContract.Persenter {
    UpdateContract.View view;

    public UpdatePresenter(UpdateContract.View view) {
        super(view);
        this.view = view;
    }

    @Override
    public void getNewVersion() {
        view.showNetDialog();
        RequestParams params = new RequestParams(UrlConfig.URL_GET_NEW_VERSION);
        params.add("versionCode", "105");
        startRequest(params, VersionBean.class, new ResponseListener() {
            @Override
            public void onRefresh(ResultData data) {
                view.dismissNetDialog();
                if (handlerRequestErr(data)) {
                    VersionBean versionBean = (VersionBean) data.getBody();
                    view.showVersionInfo(versionBean);
                }
            }
        });
    }
}
