// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1:
//
// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。
// Related Topics 数学 动态规划
// 👍 366 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

// Java：整数拆分
public class P343IntegerBreak {
  public static void main(String[] args) {
    Solution solution = new P343IntegerBreak().new Solution();
    // TO TEST
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int[] memo;

    public int integerBreak(int n) {

      if (n < 1) throw new IllegalArgumentException("n should be greater than zero");
      memo = new int[n + 1];
      Arrays.fill(memo, -1);
      return breakInteger(n);
    }

    private int breakInteger(int n) {
      if (n == 1) return 1;

      if (memo[n] != -1) {
        return memo[n];
      }

      int res = -1;

      for (int i = 1; i <= n - 1; i++) {
        res = Math.max(Math.max(res, i * (n - i)), i * breakInteger(n - i));
      }

      memo[n] = res;

      return res;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
