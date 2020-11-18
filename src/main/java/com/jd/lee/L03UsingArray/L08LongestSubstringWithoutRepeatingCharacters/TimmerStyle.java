package com.jd.lee.L03UsingArray.L08LongestSubstringWithoutRepeatingCharacters;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

/**
 * @author: gaohongbin5
 * @date: 2020/10/29 20:37:09
 * @description: TimmerStyle
 */
public class TimmerStyle {
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(
        new TimerTask() {
          @Override
          public void run() {
            System.out.println("it runs");
          }
        },1000,1000);

  }
}
