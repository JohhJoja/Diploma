package com.dima.eliseev;

import com.dima.eliseev.auth.LoginFrame;
import com.dima.eliseev.main_interface.Multithread;

public class Main {
    public static void main(String[] args) {

        //new LoginFrame();

        Multithread my_firstThread = new Multithread();
        Multithread my_secondThread = new Multithread();
        my_firstThread.start();
        my_secondThread.start();
    }
}