//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 649 👎 0

package leetcode.editor.cn;
//Java：两两交换链表中的节点
public class P24SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        return localSwapPairs(dummyNode);
    }

    private ListNode localSwapPairs(ListNode node) {
        ListNode p = node;
        ListNode node1 = node.next;
        ListNode node2 = node1.next;
        ListNode next = node2.next;
        node1.next = next;
        node2.next = node1;
        node.next = node2;
        p = node2;
        return localSwapPairs(p);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}