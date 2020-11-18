package com.jd.lee.L03UsingArray.L08LongestSubstringWithoutRepeatingCharacters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: gaohongbin5
 * @date: 2020/10/29 20:17:49
 * @description: ThreadPool
 */
public class ThreadPool {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 1000; i++) {
      executorService.submit(new Task(){});
    }
  }


}
class Task implements Runnable{

  @Override
  public void run() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName());
  }
}
