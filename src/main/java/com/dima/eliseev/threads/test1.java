package com.dima.eliseev.threads;

public class test1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println("Running first thread! His name: "+Thread.currentThread().getName());
        }
    }
}
