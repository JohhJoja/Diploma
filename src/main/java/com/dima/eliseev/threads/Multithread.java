package com.dima.eliseev.threads;

public class Multithread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println("Thread - "+Thread.currentThread().getName() + " - "+i);
        }
    }

    public static void main(String[] args) {
        new Multithread();
    }
}


