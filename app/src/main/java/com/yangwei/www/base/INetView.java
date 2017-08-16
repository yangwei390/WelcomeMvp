package com.yangwei.www.base;

/**
 * 涉及到网络异步dialog的view接口
 * Created by yangwei on 2017/8/16.
 */

public interface INetView<T> extends IBaseView<T> {
    void showNetDialog();

    void dismissNetDialog();
}
