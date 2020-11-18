package com.jd.lee.L03UsingArray.L08LongestSubstringWithoutRepeatingCharacters;

/**
 * @author: gaohongbin5
 * @date: 2020/10/28 15:20:25
 * @description: Test
 */
public class Test implements Runnable{
  public static void main(String[] args) {

    //test1();

    //test2();

    //test3();
    Thread thread = new Thread(new Test());

  }

  private static void test3() {
    int a = 2;
    int b = a + (3 * a++);
    System.out.println(b);
  }

  private static void test2() {
    int a = 2;
    int b = (3 * a++) + a;
    System.out.println(b);
  }


  private static void test1() {
    int i = 0;
    int b = i++;

    //int a = ++i;
    System.out.println("i = " + i);
    //System.out.println("a = " + a);
    //System.out.println("b = " + b);
  }

  @Override
  public void run() {
    System.out.println("使用runnable创建线程");
  }
}
