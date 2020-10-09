// 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
// ]
//
// Related Topics 栈 树 广度优先搜索
// 👍 275 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Java：二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    root.right = right;
    root.left = left;

    right.right = new TreeNode(4);
    left.left = new TreeNode(5);

    solution.zigzagLevelOrder(root);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if (root == null){
        return new ArrayList<List<Integer>>();
      }

      List<List<Integer>> res = new ArrayList<>();


       LinkedList<TreeNode> nodes = new LinkedList<>();
       nodes.addLast(root);
       nodes.addLast(null);

       LinkedList<Integer> levelList = new LinkedList<>();
       boolean isOrderLeft = true;
       while (!nodes.isEmpty()){
         TreeNode currNode = nodes.pollFirst();
         if (null != currNode){
           if (isOrderLeft){
             levelList.addLast(currNode.val);
           }else{
             levelList.addFirst(currNode.val);
           }

           if (null != currNode.left){
             nodes.addLast(currNode.left);
           }

           if (null != currNode.right){
             nodes.addLast(currNode.right);
           }

         }else{
           res.add(levelList);
           levelList = new LinkedList<>();

           if (!nodes.isEmpty()){
             nodes.addLast(null);
           }
           isOrderLeft = !isOrderLeft;

         }
       }


      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
