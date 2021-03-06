package com.yangwei.www.contract;

import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.base.IBaseView;
import com.yangwei.www.bean.VersionBean;

/**
 * Created by yangwei on 2018/5/30.
 */

public interface UpdateContract {

    interface View extends IBaseView {
        void showVersionInfo(VersionBean versionBean);
    }

    interface Presenter extends IBasePresenter {
        void getNewVersion();
    }
}
