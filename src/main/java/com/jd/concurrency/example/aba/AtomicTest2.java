package com.jd.concurrency.example.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest2 {

    private static AtomicInteger index = new AtomicInteger(10);

    static AtomicStampedReference<Integer> stampedRef = new AtomicStampedReference<>(10,1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = stampedRef.getStamp();
            System.out.println(Thread.currentThread().getName() + "第1次版本号：" + stamp);
            stampedRef.compareAndSet(10,11,stampedRef.getStamp(),stampedRef.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "第2次版本号：" + stampedRef.getStamp());
            stampedRef.compareAndSet(11,10,stampedRef.getStamp(),stampedRef.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "第3次版本号：" + stampedRef.getStamp());
        },"张三").start();

        new Thread(() -> {
            try{
                int stamp = stampedRef.getStamp();
                System.out.println(Thread.currentThread().getName() + "第1次版本号：" + stamp);
                TimeUnit.SECONDS.sleep(10);
                boolean isSuccess = stampedRef.compareAndSet(10,12,stamp,stampedRef.getStamp() +1);
                System.out.println(Thread.currentThread().getName() + "修改是否成功：" + isSuccess +" 当前版本：" + stampedRef.getStamp());
                System.out.println(Thread.currentThread().getName() + "当前实际值： " + stampedRef.getReference());
            }catch (Exception e){
                e.printStackTrace();
            }
        },"李四").start();
    }
}
