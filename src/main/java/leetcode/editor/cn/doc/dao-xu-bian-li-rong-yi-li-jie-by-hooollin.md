因为只涉及到对路径的简化，并没有`cd somedir`等从上往下切换目录的操作，如果从前往后遍历那么很显然需要记录已经访问到的路径名，还需要对".."进行返回上一级的操作，感觉很麻烦。

那么转换一下思路，如果从后往前遍历的话，如果碰到".."，那么对于接下来碰到的有效路径名，我们首先消除掉".."的影响，直接跳过；在没有碰到".."之前或是碰到的".."已经被处理完了，那么我们访问到的路径名就一定在最后的有效路径名里面；

思路比较简单，代码如下。
```
public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        List<String> res = new ArrayList<>();
        int jmpCount = 0;
        for(int i = dirs.length - 1; i >= 0; i--){
            // 当前目录和空目录的情况跳过
            if(dirs[i].equals("") || dirs[i].equals(".")){
                continue;
            }
            // 如果要跳到父目录，记录一下需要跳过非" "、"."、".."的数量
            if(dirs[i].equals("..")){
                jmpCount += 1;
                continue;
            }
            // 如果之前累计的跳到父目录还有没处理完，那么当前的目录需要跳过
            if(jmpCount > 0){
                jmpCount -= 1;
                continue;
            }
            res.add(0, dirs[i]);
        }
        return "/" + String.join("/", res);
    }
```