package com.example.demo;

import java.util.Queue;

/**
 * 生产者
 */
public class Productor implements Runnable {

    private Queue<Integer> queue;

    Productor(Queue<Integer> queue) {
        this.queue = queue;
    }

    private Integer i = 0;

    @Override
    public void run() {
        while (true) {
            product();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("生产者sleep error");
            }
        }
    }

    private void product() {
        synchronized (queue) {
            if (queue.size() < 10) {
                queue.add(i);
                i++;
            }
            System.out.println("Productor正在工作,当前缓冲区长度" + queue.size());
            while (true) {

                if (queue.size() >= 10) {
                    try {
                        System.out.println("Productor正真睡觉");
                        queue.wait();
                        System.out.println("Productor醒了");
                    } catch (Exception e) {
                        System.out.println("Productor正真睡觉出错");
                        queue.notify();
                    }
                } else {
                    break;
                }
            }
            queue.notify();
            System.out.println("生产者唤醒消费者消费");
        }
    }
}
