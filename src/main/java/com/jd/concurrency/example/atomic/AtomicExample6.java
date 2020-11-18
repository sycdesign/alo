package com.jd.concurrency.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: gaohongbin5
 * @date: 2020/11/18 09:59:14
 * @description: AtomicExample4
 */
public class AtomicExample6 {
  public final static Logger log = LoggerFactory.getLogger(AtomicExample4.class);
  public static final int clientTotal = 5000;
  public static final int threadTotal = 200;
  public static AtomicBoolean isHappened = new AtomicBoolean(false);
  public static void main(String[] args){
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
    for (int i = 0; i < clientTotal; i++) {
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          test();
          semaphore.release();
        } catch (Exception e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      });
    }
    log.info("isHappened:{}",isHappened.get());
  }

  private static void test() {
    if (isHappened.compareAndSet(false,true)){
      log.info("execute");
    }

  }
}
