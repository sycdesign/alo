### 128. 最长连续序列

- [方法一：排序](#方法一：排序)
- [方法二：集合](#方法二：集合)
- [方法三：哈希表](#方法三：哈希表)
- [方法四：并查集](#方法四：并查集)

#### 方法一：排序

##### 参考代码

```java
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Arrays.sort(nums);

    // max 最终结果, curr 当前长度, last 上个数字
    int max = 1, curr = 1, last = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == last) continue;
        if (nums[i] == last + 1) curr++; // 符合连续，长度 +1
        else {
            max = Math.max(max, curr); // 连不上了，记录长度
            curr = 1; // 重新开始
        }
        last = nums[i];
    }
    max = Math.max(max, curr); // 别忘了最后一段的连续区间
    return max;
}
```

##### 复杂度分析

- 时间复杂度：*O(nlog(n))*
- 空间复杂度：*O(1)*
  - 副作用：影响原数组

---

#### 方法二：集合

##### 思路

- 利用 *O(1)* 时间复杂度「查询是否有下一个」
- 优化：如果有比自己小一点的，那自己不查，让小的去查（详见代码）
  - 贪心思想？

##### 参考代码

```java
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    int n = nums.length, max = 1;
    Set<Integer> set = new HashSet<>();
    for (int v : nums) set.add(v);

    for (int v : nums) {
        // 技巧：如果有比自己小一点的，那自己不查，让小的去查
        if (set.contains(v - 1)) continue;

        int r = v; // r: right 表示「以 v 开头，能连续到多少」
        while (set.contains(r + 1)) r++; // 逐个查看
        max = Math.max(max, r - v + 1); // 记录区间 [v, r] 长度
    }
    return max;
}
```

##### 复杂度分析

- 时间复杂度：*O(n)*
  - 虽 `for` 内有 `while`，但每个元素最多被查 `2` 次
  - 第一次在 `set.contains(v - 1)`，如元素 `5` 被 `6` 查
  - 第二次在 `set.contains(r + 1)`，如元素 `5` 被 `4` 查
- 空间复杂度：*O(n)*

---

#### 方法三：哈希表

##### 思路

- 虽然代码结构与上述 「方法二：集合」十分相似，但思路由差异，值得提及
- 少了方法二的优化：只对小的执行查询
- 利用前面已知的右边界，快速找到当前需要的右边界（详见代码）
  - 记忆化

##### 参考代码

```java
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Map<Integer, Integer> map = new HashMap<>(); // 记录区间 [v, r]
    for (int v : nums) map.put(v, v);

    int max = 1;
    for (int v : nums) {
        int r = v;
        while (map.containsKey(r + 1))
            r = map.get(r + 1); // 利用前面已知的右边界，快速找到当前需要的右边界
        map.put(v, r);
        max = Math.max(max, r - v + 1);
    }
    return max;
}
```

##### 复杂度分析

- 时间复杂度：*O(n)*
- 空间复杂度：*O(n)*

---

#### 方法四：并查集

##### 思路

- 初始：所有元素各自为战
- 首次遍历：所有元素 `x` 向各自邻居 `x + 1`，发起结盟，并「以大者为领队」
  - 若有邻居，才结盟成功
  - 领队，即 区间右边界
  - 不只是元素 `x` 与邻居 `x + 1` 结盟，而是整个 `x` 所在队伍与整个 `x + 1` 所在队伍结盟
    - 如 `[1, 2, 3]` 与 `[4, 5]` 两个队伍结盟
- 二次遍历：记录所有人与其领队距离
  - 距离，即 区间右边界 - 当前元素 + 1

##### 参考代码

```java
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    
    // 首次遍历，与邻居结盟
    UnionFind uf = new UnionFind(nums);
    for (int v : nums)
        uf.union(v, v + 1); // uf.union() 结盟

    // 二次遍历，记录领队距离
    int max = 1;
    for (int v : nums)
        max = Math.max(max, uf.find(v) - v + 1); // uf.find() 查找领队
    return max;
}
```
```java
class UnionFind {
    private int count;
    private Map<Integer, Integer> parent; // (curr, leader)

    UnionFind(int[] arr) {
        count = arr.length;
        parent = new HashMap<>();
        for (int v : arr)
            parent.put(v, v); // 初始时，各自为战，自己是自己的领队
    }

    // 结盟
    void union(int p, int q) {
        // 不只是 p 与 q 结盟，而是整个 p 所在队伍 与 q 所在队伍结盟
        // 结盟需各领队出面，而不是小弟出面
        Integer rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        if (rootP == null || rootQ == null) return;

        // 结盟
        parent.put(rootP, rootQ); // 谁大听谁
        // 应取 max，而本题已明确 p < q 才可这么写
        // 当前写法有损封装性，算法题可不纠结

        count--;
    }

    // 查找领队
    Integer find(int p) {
        if (!parent.containsKey(p))
            return null;

        // 递归向上找领队
        int root = p;
        while (root != parent.get(root))
            root = parent.get(root);

        // 路径压缩：扁平化管理，避免日后找领队层级过深
        while (p != parent.get(p)) {
            int curr = p;
            p = parent.get(p);
            parent.put(curr, root);
        }

        return root;
    }
}
```

##### 复杂度分析

- 时间复杂度：*O(n)*
- 空间复杂度：*O(n)*