//给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。 
//
// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。 
//
// 注意：中心下标可能出现在数组的两端。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//中心下标是 3 。
//左侧数之和 (1 + 7 + 3 = 11)，
//右侧数之和 (5 + 6 = 11) ，二者相等。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心下标。 
//
// 示例 3： 
//
// 
//输入：nums = [2, 1, -1]
//输出：0
//解释：
//中心下标是 0 。
//下标 0 左侧不存在元素，视作和为 0 ；
//右侧数之和为 1 + (-1) = 0 ，二者相等。
// 
//
// 
//
// 提示： 
//
// 
// nums 的长度范围为 [0, 10000]。 
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组 
// 👍 312 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindPivotIndex {
    public static void main(String[] args) {

        Solution solution = new FindPivotIndex().new Solution();
        int[] testCase1 = new int[]{1, 7, 3, 6, 5, 6};
        int result = solution.pivotIndex(testCase1);
        System.out.println(result);

        int[] testCase2 = new int[]{1, 2, 3};
        int result2 = solution.pivotIndex(testCase2);
        System.out.println(result2);

        int[] testCase3 = new int[]{2, 1, -1};
        int result3 = solution.pivotIndex(testCase3);
        System.out.println(result3);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        /**
         * allSum - preSum - num[i] = preSum
         *
         * 2*preSum = allSum - num[i]
         */
        int allSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (allSum - nums[i] == 2* preSum[i]){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}