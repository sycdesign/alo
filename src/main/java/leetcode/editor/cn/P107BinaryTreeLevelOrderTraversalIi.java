// 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
// ]
//
// Related Topics 树 广度优先搜索
// 👍 343 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

// Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi {
  public static void main(String[] args) {
    Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
    TreeNode root = new TreeNode(10);
    TreeNode left = new TreeNode(8);
    TreeNode right = new TreeNode(12);
    root.left = left;
    root.right = right;

    left.left = new TreeNode(6);
    left.right = new TreeNode(9);

    solution.levelOrderBottom(root);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      if (root == null){
        return new ArrayList<List<Integer>>();
      }
      LinkedList<List<Integer>> res = new LinkedList<>();

      Deque<Pair> queue = new LinkedList<>();
      queue.addLast(new Pair(root,0));

      while (!queue.isEmpty()){
        Pair p = queue.pop();
        TreeNode node = (TreeNode) p.getKey();
        int level = (int) p.getValue();
        if (res.size() == level){
          List<Integer> l = new ArrayList<>();
          res.add(0,l);
        }
        res.getFirst().add(node.val);
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
