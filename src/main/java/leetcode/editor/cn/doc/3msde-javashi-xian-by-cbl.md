### 解题思路
此处撰写解题思路
采用双指针方法，不断往中间收敛，时刻记录最大的面积即可
### 代码

```java
class Solution {
    public int maxArea(int[] height) {
        // 双指针
        int maxAreaValue = 0;
        int left = 0;
        int right = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (right != left) {
                // 选择短板
                int minHeight = height[left] > height[right] ? height[right] : height[left];
                // 记录最大的面积值
                maxAreaValue = minHeight * (right - left) > maxAreaValue ? minHeight * (right - left) : maxAreaValue;
                // 找出最小的高度，并收紧
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return maxAreaValue;
    }
}
```