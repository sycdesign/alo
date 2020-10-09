// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
// 二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
// Related Topics 树 广度优先搜索
// 👍 662 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

// Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
    TreeNode root = new TreeNode(10);
    TreeNode left = new TreeNode(8);
    TreeNode right = new TreeNode(12);
    root.left = left;
    root.right = right;

    left.left = new TreeNode(6);
    left.right = new TreeNode(9);

    solution.levelOrder(root);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null){
        return res;
      }
      Deque<Pair> queue = new LinkedList<>();
      queue.addLast(new Pair(root,0));

      while (!queue.isEmpty()){
        Pair p = queue.pop();
        TreeNode node = (TreeNode) p.getKey();
        int level = (int) p.getValue();
        if (res.size() == level){
          List<Integer> l = new ArrayList<>();
          res.add(l);
        }
        res.get(level).add(node.val);
        if (null != node.left){
          queue.addLast(new Pair(node.left,level + 1));
        }
        if (null != node.right) {
          queue.addLast(new Pair(node.right, level + 1));
        }
      }

      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
