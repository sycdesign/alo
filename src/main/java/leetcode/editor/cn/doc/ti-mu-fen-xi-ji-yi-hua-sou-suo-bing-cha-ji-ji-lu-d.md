![默认文件1600012458323](https://pic.leetcode-cn.com/1600053007-MLqDBr-file_1600053007226)

大家好，欢迎来到算法妙妙屋，这里是今天的每日一题环节。

今天我们会为大家介绍一道算法题，最长连续序列，这道题目曾作为原题出现在字节跳动二面上。
在介绍完这道题目之后，我们会介绍一道解题方法上上与第一题有关联，但难度上更胜一筹的腾讯笔试题。

首先是第一题，最长连续子序列。

# Leetcode-128.最长连续子序列

给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 *O(n)*
>示例： 
>输入: [100, 4, 200, 1, 3, 2]
>输出: 4
>解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

## 缓解尴尬用的算法

假如你在面试中被问到了这道题目，一时半会又想不出解法，你可以先说一个无脑但是肯定正确的解法来缓解尴尬。
一个很容易想到的解法是*O(nlogn)*的，对原数组进行排序并去重，然后一遍扫描就能直到答案。


```c++
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        // 对整个数组进行排序
        sort(nums.begin(), nums.end());
        // 去重操作
        nums.erase(unique(nums.begin(), nums.end()), nums.end());
        // ans 是最终答案，cnt用于记录临时答案
        int ans = 0, cnt = 0;
        for (int i = 0; i < nums.size(); i++){
            if (i > 0 && nums[i] == nums[i-1] + 1)
                cnt++;
            else
                cnt = 0;
            ans = max(ans, cnt+1);
        }
        return ans;
    }
};

```

讲完之后你还可以跟面试官分析一下时间复杂度*O(nlogn)*的sort,之后的unique和for循环遍历都是*O(n)*的，所以总体时间复杂度为*(O(nlogn))*。

缓解完尴尬之后，你可以喝一口水，面试的时候一定要有一个水杯在边上水，这也是缓解尴尬的神奇。

然后如果你是男生，你可以捋一捋胡须，如果你是女生可以抓一抓头发，我们继续思考正解。

## 问题分析

首先我们看一下问题的时间复杂度要求，*O(n)*。
看到这个时间复杂度要求，基本上我们就要放弃所有与排序有关的算法了。

* 我们不能使用sort，因为sort时间复杂度为*O(nlogn)*
* 同理我们也不能使用set,map等一系列基于树的容器，因为这些容器的插入与查找操作时间复杂度均为*O(logn)*,我们将只能执行常数次的插入或查找。
* 同时我们在vector 上只能执行常数次遍历操作，因为每次遍历的代价都是*O(n)*。

看来这一题的容器，我们只能选择hash表了。

hash表的插入，删除和查找都只有*O(1)*的时间复杂度，你此刻是否好奇，那set和map存在的意义是什么。


>因为hash表是无序的呀，**么么哒**。
>set 和 map 拿 O（logn）的复杂度去排了个序

而上面缓解尴尬用的算法并不能直接拿过来用，原因就是hash表缺乏的有序性。

```c++
int ans = 0, cnt = 0;
for (int i = 0; i < nums.size(); i++){
    // i > 0避免越界，后面部分判断i与i-1是否是连续的
    if (i > 0 && nums[i] == nums[i-1] + 1)
        cnt++;
    else
        cnt = 0;
    ans = max(ans, cnt+1);
}
```

这一段代码中，我们能放心地使用cnt记录长度，就是因为hash我们确信每一个v在访问前，v-1如果存在，就一定已经被访问过了，而且v-1的长度被累加在了cnt中。

所以我们接下来使用的算法一定是一些，不依赖有序访问元素的算法。

<!-- 有没有有序的hash表呢？还真的有，我们似乎有了一个点子，我们可以开一个大小为101的指示数组*A*，初始化为0，对于数组中的每一个元素*u*，我们让*A[u] = 1*，这样子问题就变成了在一个数组上查找最长的连续1的过程。我们可以在我们只要遍历*A*就能完成运算。

|*A[0]* |*A[1-4]*   |*A[5-99]*  |*A[100]* |*A[101-199]* | *A[200]*|
|----   | ----      | ----      | ----    | ----        | ----  |
|0      | 1         | 0         | 1       | 0           | 1     |

不过现实再一次打了我们的脸。题目中并没有说明数组中元素最大值是多少，总不能数组中最大的元素是*10^9*，我们也开一个大小为*10^9*的数组。

不过貌似我们已经找到希望了，刚才用指示数组的手法，其实 -->

## 采取动态规划记忆化搜索的方法

其实这个方法也可以被认为是，有向无环图求最长路的方法。
对于每个v我们都从v向v+1连一条线的话，输入数据就会成为一个有向无环图。

![DAG](https://pic.leetcode-cn.com/1600053007-JhepIY-file_1600053007228)

图画的很丑，大家见谅，但是是能看出来这里有一条最长路的。我们可以用一个基于hash的map记录答案。 mp[v]代表以v为起点的最长路的长度，同时有

*   递推式：mp[v] = mp[v+1] + 1, if v+1 in mp
*   基情况: mp[v] = 0, if v not in mp

代码与时间复杂度分析如下：


```c++
class Solution {
public:
    // 记忆化搜索 返回的结果是以v为起点的最长路的长度
    int dfs(unordered_map<int, int>& mp, int v){
        // 如果v不在集合中，就直接返回0，代表以v为起点的路长度为0
        if (mp.find(v) == mp.end()) 
            return 0;
        // 如果这个节点已经搜索一遍了，直接返回结果
        if (mp[v] != 0)
            return mp[v];
        // 如果当前节点还没有结果，
        // 我们就去询问v+1为起点的最长路长度， 并+1得到自身的答案
        // 并记录结果
        return mp[v] = dfs(mp, v+1) + 1;
    }
    int longestConsecutive(vector<int>& nums) {
        // mp[v] 表示以v为起点的最长路的长度
        unordered_map<int, int> mp;
        // 将数据插入mp并进行初始化
        for (auto v: nums)
            mp[v] = 0;
        int ans = 0;
        // 对每个元素进行记忆化搜索
        for (auto v: nums){
            ans = max(ans, dfs(mp, v));
        }
        return ans;
    }
};
```
插入部分因为采用hash map，时间复杂度为*O(n)*，dfs部分的话，每个元素v最多被访问两次，一次是以*v*为起点的dfs,一次是v-1递归地访问v。dfs部分时间复杂度也是*O(n)*。
算法整体时间复杂度为*O(n)*


## 采用并查集

还是从图论的角度去思考这个问题，如果我们在v和v+1之间连一条边，那么这个问题就变成了寻找图中最大连通集的问题。

这个问题我们可以用并查集来解决，我们只需要用两个hash map 同时维护并查集，和并查集中每一个连通集的大小即可。

代码和时间复杂度分析贴在下面了。


```c++
class Solution {
public:
    // rt 用于记录指向， sz 用于记录并查集这一子集的大小
    unordered_map<int, int> rt, sz;
    int find(int v){
        // 这一步写法综合了路径压缩以及根的查找
        return rt[v]==v?v:rt[v] = find(rt[v]); 
    }
    int merge(int u, int v){
        u = find(u); 
        v = find(v);
        // 如果u和v不在同一个集合中
        if (u != v){
            // 合并集合的size
            sz[u] += sz[v];
            // 修改元素的指向
            rt[v] = rt[u];
        }
        // merge 函数返回当前集合的大小
        return sz[u];
    }
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        int ans = 1;
        for (auto v:nums){
            // 对并查集进行初始化
            // rt[v] = v 代表v是自己所在这个集合的根
            rt[v] = v;
            sz[v] = 1;
        }
        for (auto v: nums){
            // 由于是连续数组，我们只需要考虑v与v-1就能照顾所有边
            if (rt.find(v-1) != rt.end())
                ans = max(ans, merge(v, -1));
        }
        return ans;
    }
};
```
由于使用了hash map 所以这里所有的访问操作都是*O(1)*。
并查集算法本身的时间复杂度严格来讲不是线性，只是极端接近线性*O(nlog^*(n))*，这里的[*log^*(n)*](https://en.wikipedia.org/wiki/Iterated_logarithm)是一个增长极端缓慢的函数，几乎可以认为是*O(1)*。

这道题的并查集有更高效的写法，在题目的讨论区可以看到，但并查集的结构不是特别明显，我把链接放在这里。
[传送门](https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/cbing-cha-ji-xie-fa-dai-ma-ji-duan-by-leck/)

## 记录另一头端点的策略

这道题还有一种解法是，记录另一头的端点。

即在遍历数组的过程中，我们维护一个记忆数组*mark*，使得对每一段连续序列![\[l,l+1,\cdots,r\] ](./p___l,_l+1,_cdots,_r__.png) ，*mark[l] = r, mark[r] = l*。

如果这种性质满足，我们就只需要对每个元素计算*|mark[i] - i|*，并取最大值即可。

可以发现，当我们单独插入一个点*u*,我们只需要设置*mark[u] = u*，就能满足我们的要求，因为*u*的左右端点都是他本身。

我们接下来只需要思考，当插入*u*之后，它的左右邻居如果存在，我们要如何维护之前的那种性质。

换一个角度就是说，当两个连续数组相邻了，我们知道他们相邻的两个元素是什么，并且他们维护了我们要求的mark标记，要如何计算新的连续数组长度，并维护之前的性质。

![mark](https://pic.leetcode-cn.com/1600053007-UTJpRh-file_1600053007229)

就像上面这张图，*5, 6, 7, 8* 和 *9, 10, 11, 12*就好像两个独立的国家，他们在扩增领土的过程中碰到了（也就是*8*,*9*的交界处），现在想要合并成一个国家，应该怎么做呢?

正解就是，*9*告诉*8*，我的另一头边界在*12*，*8*告诉*9*，我的另一头边界在*5*。然后他们分别把*12*这个信息送给*8*， 把*5*这个消息送给*12*， 再互相更新就可以了。
![mark2](https://pic.leetcode-cn.com/1600053007-uPbTPJ-file_1600053007232)

代码实现和复杂度分析如下

```c++
class Solution {
public:
    unordered_map<int, int> mark;
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        // 如果集合不为空，最长连续数组长度至少为1
        int ans = 1;
        for (auto v :nums){
            if (mark.find(v) == mark.end()){
                // 刚插入的时候，v的左右边界都是他本身，直接赋值即可
                mark[v] = v;
                // 遍历左右邻居
                for (auto u: {v-1, v+1}){
                    auto it = mark.find(u);
                    // 如果i+1的邻居已经存在于表中
                    if (it != mark.end()){
                        // 用x代表v的另一端位置， 用y代表v+i的另一端位置
                        int x = mark[v], y = mark[u];
                        // 两个端点分别记录位置
                        mark[x] = y;
                        mark[y] = x;
                        // 更新答案
                        ans = max(ans, abs(x - y) + 1);
                    }
                }
            }
        }
        return ans;
    }
};
```
用到hash map的地方都是线性的，每个元素*u*插入之后，我们最多会进行两次合并，即和*u+1*合并或者和*u-1*合并，每次合并的代价不过四次赋值，以及一次max运算，因此是常数量级的。
所以整体算法复杂度是线性的。

# 总结与真题

其实官方还有一种解法，但是感觉不是特别有意思，就不晒了。
这里提供一道美团笔试的真题，可以使用上面的思路就行求解快来试一试吧
### 小美的仓库整理

#### 题目描述
小美是美团仓库的管理员，她会根据单据的要求按顺序取出货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界限分为两堆，这样可以保证货物局部的顺序不变。

已知货物最初是按1-n的顺序堆放的，每件货物的重量为w_i，小美会根据单据依次不放回地取出货物。请问根据上述操作，小美每取出一件货物后，重量和最大的一堆货物重量是多少？
#### 输入描述
输入第一行包含一个正整数n，表示货物的数量。（1<=n<=50000）

输入第二行包含n个正整数，表示1-n号货物的重量w_i。（1<=w_i<=100）

输入第三行有n个数，表示小美按顺序取出的货物的编号，也就是一个1-n的全排列。
#### 输出描述
输出包括n行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
#### 样例输入
5
3 2 4 4 5
4 3 5 2 1
#### 样例输出
9
5
5
3
0


原题是从一个序列中每次删除一个元素，并求最大的未删除的元素序列和。
比如第一个数据 
3 2 4 4 8
删除了第四个4之后，变成了
3 2 4 - 5
因此最大和为*3+2+4 = 9*。
但我们也可以，倒着理解这个过程。
起初数组是空的，此时最大连续和是**0**。

比如我们现在1号位置插入3，得到
3 - - - - 
此时最大连续和是**3**。
接着我们再2号位置插入2, 得到
3 2 - - - 
此时最大连续和是**5**。
然后我们再5号位置插入5，
得到
3 2 - - 5
最大连续和依旧是**5**
然后是3号位置插入4
3 2 4 - 5
最大连续和是**9**

我们得到的答案 0 3 5 5 9,正好是正确答案翻过来。
因此我们可以将所有输入，把删除操作改成插入操作，因为处理插入要比处理删除简单得多。

至于如何维护插入过程中的连续最大和，就需要用到这篇推送中的想法了。


不知道今天的推送是否使你觉得有收获，如果有收获的话，欢迎留言点赞。

算法妙妙屋，再会！！
![扫码_搜索联合传播样式-标准色版](https://pic.leetcode-cn.com/1600053007-VZnsBN-file_1600053007235)