package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayDeque;
import java.util.Queue;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Queue<Integer> buffer = new ArrayDeque<Integer>(10);
        Productor productor = new Productor(buffer);
        Consumer consumer = new Consumer(buffer);

        new Thread(productor).start();
        new Thread(consumer).start();
//        MyTread myTread = new MyTread("chenshu");
//        Thread thread1 = new Thread(myTread, "chengshu1");
//        Thread thread2 = new Thread(myTread, "chengshu2");
//        thread2.start();
//        thread1.start();
//        myTread.start();
//        System.out.println("当前线程:" + Thread.currentThread().getName());

//        SpringApplication.run(DemoApplication.class, args);
    }
}
