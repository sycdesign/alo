### 解题思路
![图片.png](https://pic.leetcode-cn.com/1600752368-zkPkcR-%E5%9B%BE%E7%89%87.png)


### 代码

```python3
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        nums.sort()
        result = dp = 0
        pre = nums[0] - 1
        for i in range(0, len(nums)):
            if nums[i] - pre == 1:
                dp += 1
            elif nums[i] - pre > 1:
                dp = 1
            result = max(result, dp)
            pre = nums[i]
        return max(result, dp)
```