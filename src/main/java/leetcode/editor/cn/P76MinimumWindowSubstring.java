// 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
//
//
//
// 示例：
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
// 输出："BANC"
//
//
//
// 提示：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 806 👎 0

package leetcode.editor.cn;
// Java：最小覆盖子串
public class P76MinimumWindowSubstring {
  public static void main(String[] args) {
    Solution solution = new P76MinimumWindowSubstring().new Solution();
    solution.minWindow("ADOBECODEBANC", "ABC");
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String minWindow(String s, String t) {
      int[] window = new int[128], need = new int[128];
      char[] ss = s.toCharArray(), tt = t.toCharArray();

      int count = 0, min = ss.length;
      String res = "";
      for (int i = 0; i < tt.length; i++) { //
        need[tt[i]]++;
      }
      int i = 0, j = 0;
      while (j < ss.length) {
        char c = ss[j];
        window[c]++;
        if (window[c] <= need[c]) count++;
        while (count == tt.length) {
          if (j - i + 1 <= min) {
            res = s.substring(i, j + 1);
            min = j - i + 1;
          }
          window[ss[i]]--;
          if (window[ss[i]] < need[ss[i]]) {
              count--;
          }
          i++;
          if (i >= ss.length) {
              break;
          }
        }
        j++;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
