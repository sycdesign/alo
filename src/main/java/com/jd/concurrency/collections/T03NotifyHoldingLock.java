package com.jd.concurrency.collections;

import java.sql.Time;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T03NotifyHoldingLock {
    static volatile List lists = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {

        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock){
                System.out.println("t2启动");
                if (lists.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 end");
                    lock.notify();
                }
            }

        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 " + i);
                    if (i==5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t1").start();

    }
}
