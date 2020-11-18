package com.jd.lee.L03UsingArray.L08LongestSubstringWithoutRepeatingCharacters;

/**
 * @author: gaohongbin5
 * @date: 2020/10/29 19:53:17
 * @description: ThreadStyle
 */
public class ThreadStyle extends Thread {

  @Override
  public void run() {
    System.out.println("Thread ");
  }

  public static void main(String[] args) {
    new ThreadStyle().start();
  }
}
