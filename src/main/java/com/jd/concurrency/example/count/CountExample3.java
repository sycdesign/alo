package com.jd.concurrency.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: gaohongbin5
 * @date: 2020/11/11 16:44:48
 * @description: CountExample1
 */
@Slf4j
public class CountExample3 {

  public static final int clientTotal = 5000;
  public static final int threadTotal = 200;
  public static int count = 0;
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
    for (int i = 0; i < clientTotal; i++) {
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          add();
          semaphore.release();
        } catch (Exception e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      });
    }
    countDownLatch.await();
    executorService.shutdown();
    log.info("count:{}",count);
  }

  private synchronized static void add() {
    count++;
  }
}
