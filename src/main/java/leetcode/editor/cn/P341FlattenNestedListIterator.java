// 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
//
//
//
// 示例 1:
//
// 输入: [[1,1],2,[1,1]]
// 输出: [1,1,2,1,1]
// 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
//
// 示例 2:
//
// 输入: [1,[4,[6]]]
// 输出: [1,4,6]
// 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
//
// Related Topics 栈 设计
// 👍 144 👎 0

package leetcode.editor.cn;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Java：扁平化嵌套列表迭代器
public class P341FlattenNestedListIterator {
  public static void main(String[] args) {
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public class NestedIterator implements Iterator<Integer> {
    Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
      stack = new Stack<>();
      initNest(nestedList, stack);
    }

    private void initNest(List<NestedInteger> nestedList, Stack<Integer> stack) {
      for (NestedInteger nest : nestedList) {
        if (nest.isInteger()) {
          stack.push(nest.getInteger());
        } else {
          initNest(nest.getList(), stack);
        }
      }
    }

    @Override
    public Integer next() {
      return stack.pop();
    }

    @Override
    public boolean hasNext() {
      return !stack.empty();
    }
  }

  /**
   * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
   * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
