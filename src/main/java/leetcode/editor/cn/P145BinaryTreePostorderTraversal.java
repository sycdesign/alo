// 给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
// 输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 393 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
  public static void main(String[] args) {
    Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      postorder(root, list);
      return list;
    }

    private void postorder(TreeNode node, List<Integer> list) {
      if (node != null) {
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
