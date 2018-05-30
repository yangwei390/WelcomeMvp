package com.yangwei.www.contract;

import com.yangwei.www.base.IBasePersenter;
import com.yangwei.www.base.IBaseView;
import com.yangwei.www.bean.VersionBean;

/**
 * Created by yangwei on 2018/5/30.
 */

public class UpdateContract {

    public interface View extends IBaseView<Persenter> {
        void showVersionInfo(VersionBean versionBean);
    }

    public interface Persenter extends IBasePersenter {
    }
}
