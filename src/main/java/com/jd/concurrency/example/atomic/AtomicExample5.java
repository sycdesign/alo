package com.jd.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: gaohongbin5
 * @date: 2020/11/18 09:59:14
 * @description: AtomicExample4
 */
public class AtomicExample5 {
  public final static Logger log = LoggerFactory.getLogger(AtomicExample5.class);

  @Getter
  public volatile int count = 100;

  private static  AtomicExample5 example5 = new AtomicExample5();

  private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
  public static void main(String[] args) {
    if (updater.compareAndSet(example5, 100, 120)){
      log.info("update success 1,{}",example5.getCount());
    }
    if (updater.compareAndSet(example5, 100, 120)){
      log.info("update success 2,{}",example5.getCount());
    }else{
      log.info("update fail,{}",example5.getCount());
    }
  }
}
