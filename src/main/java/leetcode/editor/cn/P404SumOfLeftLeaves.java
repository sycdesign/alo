//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 243 👎 0

package leetcode.editor.cn;


//Java：左叶子之和
public class P404SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    P101SymmetricTree.TreeNode left;
    P101SymmetricTree.TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}