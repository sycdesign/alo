//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1060 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：打家劫舍
public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //状态
        //考虑偷取[x...n-1]范围里的房子

        //状态转移 f0 = max{v0 + f(2),v1 + f(3),...,v(n-3)+fn-1,v(n-2),v(n-1)}

    /*int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return tryRob(nums,0);
    }*/

        //考虑 nums[index,...nums.size())这个范围的所有房子
    /*private int tryRob(int[] nums, int index) {
        if(index >= nums.length){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res , nums[i] + tryRob(nums, i +2));
        }
        memo[index] = res;

        return res;
    }*/


        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0){
                return 0;
            }
            // memo[i]表示考虑抢劫nums[i...n-1]所能获得的最大收益
            int[] memo = new int[n];
            Arrays.fill(memo, -1);
            memo[n-1] = nums[n-1];

            for(int i = n-2; i >=0; i--){
                //memo[i]
                for(int j = i; j <n;j++){
                    memo[i] = Math.max(memo[i],nums[j] + (j+2 < n ? memo[j+2] : 0));
                }
            }
            return memo[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}