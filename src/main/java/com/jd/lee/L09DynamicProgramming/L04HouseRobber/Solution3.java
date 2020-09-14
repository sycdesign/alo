package com.jd.lee.L09DynamicProgramming.L04HouseRobber;

import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索, 改变状态定义
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution3 {

    // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, nums.length - 1);
    }

    // 考虑抢劫nums[0...index]这个范围的所有房子
    private int tryRob(int[] nums, int index) {

        if (index < 0)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = 0; i <= index; i++)
            res = Math.max(res, nums[i] + tryRob(nums, i - 2));
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution3()).rob(nums));
    }
}
