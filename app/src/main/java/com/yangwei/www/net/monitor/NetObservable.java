package com.yangwei.www.net.monitor;

import java.util.Observable;

/**
 * Created by yangwei on 2018/7/17.
 */

public class NetObservable extends Observable {
    private static NetObservable instance = null;

    public static NetObservable getInstance() {
        if (instance == null) {
            synchronized (NetObservable.class) {
                if (instance == null) {
                    instance = new NetObservable();
                }
            }
        }
        return instance;
    }

    public void notifNetChange(NetType netType) {
        setChanged();
        notifyObservers(netType);
    }
}
