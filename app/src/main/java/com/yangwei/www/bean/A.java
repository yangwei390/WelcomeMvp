package com.yangwei.www.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yangwei
 * @Date 2019/4/16
 * @Description A
 */
public class A implements Parcelable {
    private int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(a);
    }

    public static final Parcelable.Creator<A> CREATOR = new Parcelable.Creator<A>() {
        @Override
        public A createFromParcel(Parcel source) {
            A a = new A();
            a.a = source.readInt();
            return a;
        }

        @Override
        public A[] newArray(int size) {
            return new A[size];
        }
    };
}
