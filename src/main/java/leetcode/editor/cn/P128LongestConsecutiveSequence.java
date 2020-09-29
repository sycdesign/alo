// 给定一个未排序的整数数组，找出最长连续序列的长度。
//
// 要求算法的时间复杂度为 O(n)。
//
// 示例:
//
// 输入: [100, 4, 200, 1, 3, 2]
// 输出: 4
// 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// Related Topics 并查集 数组
// 👍 566 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Java：最长连续序列
public class P128LongestConsecutiveSequence {
  public static void main(String[] args) {
    Solution solution = new P128LongestConsecutiveSequence().new Solution();

    int[] nums = new int[] {100, 4, 200, 1, 3, 2};
    solution.longestConsecutive(nums);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int longestConsecutive(int[] nums) {
      //        return baoli(nums);
      //        return setMethod(nums);
      return leftrightMethod(nums);
    }

    private int leftrightMethod(int[] nums) {
      int res = 0;
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int n : nums) {
        if (!map.containsKey(n)) {
          int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
          int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
          // sum: length of the sequence n is in
          int sum = left + right + 1;
          map.put(n, sum);

          // keep track of the max length
          res = Math.max(res, sum);

          // extend the length to the boundary(s)
          // of the sequence
          // will do nothing if n has no neighbors
          map.put(n - left, sum);
          map.put(n + right, sum);
        } else {
          // duplicates
          continue;
        }
      }
      return res;
    }

    private int setMethod(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int n = nums.length, max = 1;

      Set<Integer> set = new HashSet<>();
      for (int v : nums) {
        set.add(v);
      }

      for (int v : nums) {
        if (set.contains(v - 1)) {
          continue;
        }

        int r = v;

        while (set.contains(r + 1)) {
          r++;
        }
        max = Math.max(max, r - v + 1);
      }
      return max;
    }

    private int baoli(int[] nums) {
      /** 暴力解法,排序后，然后再找出 时间复杂度nlog(n) */
      if (nums.length == 0) {
        return 0;
      }
      Arrays.sort(nums);
      // max 最终结果，curr 当前长度，last 上个数字
      int max = 1, curr = 1, last = nums[0];
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == last) {
          continue;
        }
        if (nums[i] == last + 1) {
          curr++;
        } else {
          max = Math.max(max, curr);
          curr = 1;
        }
        last = nums[i];
      }
      /** 最后一段连续区间 */
      max = Math.max(max, curr);
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
