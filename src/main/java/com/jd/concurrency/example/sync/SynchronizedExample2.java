package com.jd.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: gaohongbin5
 * @date: 2020/11/18 13:55:09
 * @description: SynchronizedExample2
 */
@Slf4j
public class SynchronizedExample2 {

  public static void test1(int j) {
    synchronized (SynchronizedExample2.class){
      for (int i = 0; i < 10; i++) {
        log.info("test1 {} - {}",j,i);
      }
    }
  }

  public static synchronized void test2(int j) {
    for (int i = 0; i < 10; i++) {
      log.info("test2 {} - {}",j,i);
    }
  }

  public static void main(String[] args) {
    SynchronizedExample2 example1 = new SynchronizedExample2();
    SynchronizedExample2 example2 = new SynchronizedExample2();

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> example1.test2(1));
    executorService.execute(() -> example2.test2(2));
  }
}
