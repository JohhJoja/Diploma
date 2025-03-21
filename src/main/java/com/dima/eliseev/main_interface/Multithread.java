package com.dima.eliseev.main_interface;

public class Multithread extends Thread{

    @Override
    public void run() {
        System.out.println("It's new thread!");
        System.out.println("Do something");
        someMethod();
    }

    static void someMethod(){
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        new Multithread();
    }
}


