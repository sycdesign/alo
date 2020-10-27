// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 717 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// Java：移动零
public class P283MoveZeroes {
  public static void main(String[] args) {
    Solution solution = new P283MoveZeroes().new Solution();
    // TO TEST
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void moveZeroes(int[] nums) {

      int k = 0; // nums中, [0...k)的元素均为非0元素

      // 遍历到第i个元素后,保证[0...i]中所有非0元素
      // 都按照顺序排列在[0...k)中
      // 同时, [k...i] 为 0
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (k != i) {
            swap(nums, k++, i);
          } else {
            k++;
          }
        }
      }
    }

    private void swap(int[] nums, int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
