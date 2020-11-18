### 解题思路
注释掉的part超时了hhhhh，已经不早了还是reverse()吧！

### 代码

```python3
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        # m = len(s)
        # n = 0
        # while n <= m/2:
        #     s[n], s[m-n-1] = s[m-n-1], s[n]
        s = s.reverse()
```