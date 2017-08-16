package com.yangwei.www.contract;

import com.yangwei.www.base.IBasePersenter;
import com.yangwei.www.base.INetView;

/**
 * Created by yangwei on 2017/8/16.
 */

public interface HomeContract {
    interface View extends INetView<Persenter> {

    }

    interface Persenter extends IBasePersenter {

    }
}
