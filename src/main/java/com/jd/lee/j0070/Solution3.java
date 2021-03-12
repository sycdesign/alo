package com.jd.lee.j0070;

public class Solution3 {

    public int climbStairs(int n) {

        if(n <= 0)
            throw new IllegalArgumentException("n must be greater than zero");

        if(n == 1)
            return 1;

        int prev = 1, cur = 1;
        for(int i = 3 ; i <= n + 1; i ++){
            int f = cur + prev;
            prev = cur;
            cur = f;
        }
        return cur;
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).climbStairs(10));
    }

}
