package com.jd.lee.j0070;

import java.util.Arrays;

public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {

        if (n <=0) throw new IllegalArgumentException("n must b greater than zero");

        memo = new int[n+1];

        Arrays.fill(memo, -1);

        return calcWays(n);

    }

    private int calcWays(int n) {
        if (n == 0 || n == 1){
            return 1;
        }

        if (memo[n] == -1){
            memo[n] = calcWays(n-1) + calcWays(n-2);
        }

        return memo[n];

    }

    public static void main(String[] args) {

        System.out.println(new Solution1().climbStairs(10));

    }
}