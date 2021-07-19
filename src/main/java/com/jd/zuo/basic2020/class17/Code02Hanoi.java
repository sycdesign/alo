package com.jd.zuo.basic2020.class17;

public class Code02Hanoi {
    private static void hanoi1(int n) {
        leftToRight(n);
    }

    // 把1~N层圆盘 从左  -> 右
    private static void leftToRight(int n) {
        //base case
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }

    }


    public static void main(String[] args) {
        int n = 3;
        hanoi1(n);
        System.out.println("===========================");
//        hanoi2(n);
    }


}
