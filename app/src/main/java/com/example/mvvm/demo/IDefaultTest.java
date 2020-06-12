package com.example.mvvm.demo;

/**
 * author:lgh on 2020/6/12 8:52
 */
public interface IDefaultTest {

    default void print(){
        System.out.println("default method...");
    }

    default String t(String s){
        return s;
    }

}
