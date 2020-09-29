// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4247 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
    // TO TEST
    solution.lengthOfLongestSubstring("pwwkew");
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n = s.length(), ans = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int end = 0, start = 0; end < n; end++) {
        char alpha = s.charAt(end);
        if (map.containsKey(alpha)) {
          start = Math.max(map.get(alpha), start);
        }
        ans = Math.max(ans, end - start + 1);
        map.put(s.charAt(end), end + 1);
      }
      return ans;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
