//在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。 
//
// 
//
// 示例： 
//
// 输入：A = [1,0,1,0,1], S = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 
//
// 提示： 
//
// 
// A.length <= 30000 
// 0 <= S <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 哈希表 双指针 
// 👍 94 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {

        Solution solution = new BinarySubarraysWithSum().new Solution();
        int[] A = new int[]{1,0,1,0,1};
        int S = 2;

        int result = solution.numSubarraysWithSum(A,S);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {

        if (A.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : A) {
            presum += x;
            //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - S)) {
                count += map.get(presum - S);//获取次数
            }
            //更新
            map.put(presum,map.getOrDefault(presum,0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}