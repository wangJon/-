package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTread extends Thread {

    private int count = 10;
    Logger log = LoggerFactory.getLogger(MyTread.class);

    MyTread(String name) {
        this.setName(name);
    }

    MyTread() {
        super();
    }

    @Override
    public void run() {
//        log.info("当前值{}", (count--));
        System.out.println("count:" + (count--) + " threadName:" + Thread.currentThread().getName());
    }
}
