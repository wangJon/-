package com.example.demo;

import java.util.Queue;

/*
 * 消费者与生产者问题
 */
public class Consumer implements Runnable {

    private Queue<Integer> queue;

    Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            consume(queue);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("消费者sleep error");
            }
        }
    }

    public void consume(Queue<Integer> queue) {
        synchronized (queue) {
            if (queue != null && queue.size() > 0) {
                System.out.println("消费者消费,消费值为:" + queue.remove());
            }
            System.out.println("Consumer工作,当前缓冲区长度为:" + queue.size());

            //真正睡眠
            while (true) {
                if (queue.size() == 0) {
                    try {
                        System.out.println("消费者真正睡眠");
                        queue.wait();
                        System.out.println("消费者醒了");
                    } catch (Exception e) {
                        queue.notify();
                        System.out.println("消费者真正睡眠出错");
                    }
                } else {
                    break;
                }
            }
            queue.notify();
            System.out.println("消费者唤醒生产者制造");
        }
    }
}
