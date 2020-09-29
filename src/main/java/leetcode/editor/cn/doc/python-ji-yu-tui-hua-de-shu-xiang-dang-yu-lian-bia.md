### 解题思路
此处撰写解题思路

对该题需要进行两遍遍历，总的时间复杂度为O（n）
首先我说一下树结构，num作为节点的话，他的左子节点为，num-1。右子节点为num+1
比如说3，他的左子节点为2，右子节点为4，对于2来讲3是他的右子节点

第一遍构造树，用字典存储对应值的节点。没遍历一个num。判断num-1存不存在，num+1存不存，存在就更新左右节点

第二遍查询树，凡是没有左子节点的就是一个连续序列的其实位置，没有右子树的就是一个序列的终止位置，统计每个序列的节点数量就行






### 代码

```python
class Node:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None


class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nodemap = dict()
        #插入过程中创建一颗树，这可树num的左子树是num-1右子树为num+1，过程也快O(N)时间复杂度
        for num in nums:
            if num not in nodemap:
                curnode = Node(num)

                if num-1 in nodemap:
                    curnode.left = nodemap[num-1]
                    nodemap[num-1].right = curnode
                if num+1 in nodemap:
                    curnode.right = nodemap[num+1]
                    nodemap[num+1].left = curnode
                nodemap[num]=curnode
                
        
        #查询森林中没有左子树的节点，就是一棵树的起始点遍历过程O（n）（为什么说是深林呢，因为过程中有好多树，每棵树就是一个连续序列）
        maxcount = 0
        for key, node in nodemap.items():
            if not node.left:
                count=1
                while node.right:#一直往右走直到右节点为None 就是一个序列的结尾
                    node = node.right
                    count+=1
                if count>maxcount:
                    maxcount = count
        return maxcount 












```