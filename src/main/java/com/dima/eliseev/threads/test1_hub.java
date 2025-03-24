package com.dima.eliseev.threads;

public class test1_hub {

    test1 thread1 = new test1();
    test1_2 thread2 = new test1_2();

    test1_hub(){
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new test1_hub();
    }
}
