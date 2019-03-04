package com.yangwei.www;

public class Outer {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);    //填入合适的代码
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}
