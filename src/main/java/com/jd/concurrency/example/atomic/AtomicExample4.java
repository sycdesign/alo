package com.jd.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: gaohongbin5
 * @date: 2020/11/18 09:59:14
 * @description: AtomicExample4
 */
public class AtomicExample4 {
  public final static Logger log = LoggerFactory.getLogger(AtomicExample4.class);

  private static AtomicReference<Integer> count = new AtomicReference<>(0);
  public static void main(String[] args) {
    count.compareAndSet(0,2);
    count.compareAndSet(0,1);
    count.compareAndSet(1,3);
    count.compareAndSet(2,4);
    count.compareAndSet(3,5);
    log.info("count:{}", count.get());
  }
}
