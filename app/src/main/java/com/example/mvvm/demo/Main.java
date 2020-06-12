package com.example.mvvm.demo;

/**
 * author:lgh on 2020/6/12 8:53
 */
class Main {

    public static void main(String[] args) {

        Test test = new Test();
        System.out.println(test.t("t..."));
        test.print();

    }

    static class Test implements IDefaultTest{

        @Override
        public String t(String s) {
            return null;
        }
    }

}
