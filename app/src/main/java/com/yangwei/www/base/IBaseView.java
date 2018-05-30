package com.yangwei.www.base;

/**
 * Created by yangwei on 2017/8/16.
 */

public interface IBaseView<T> extends INetView {
    void setPersenter(T persenter);
}
