### 解题思路
主要设计了五种状态：
- 读到一个点
- 读到两个点
- 读到分隔符号
- 读到普通字符串
- 错误

每次读取一个字符，根据当前字符、及当前状态，决定下一步的状态应该是什么。

对于该题目，每个输入都是"/"开头的。所以对于任何输入，都从“读到分隔符”状态开始，进行状态的流转，
最后一趟读完之后，再判断一下末位状态，做一下收尾工作

### 代码

```java
class Solution {
     public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        if (path.charAt(0) != '/') throw new RuntimeException("invalid path.");
        Context context = new Context();
        //从读到分隔附开始
        State state = State.SEPRA;
        //状态流转
        for (int i = 1; i < path.length(); i++) {
            State next = state.next(path.charAt(i), context);
            if (next == State.ERROR) throw new RuntimeException("parse err.");
            state = next;
        }
        //收尾工作
        if (state == State.NAME) {
            context.flush();
        } else if (state == State.DOT2) {
            context.removeLast();
        }
        //组装结果
        List<String> validStrings = context.getValidStrings();
        if (validStrings.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        for (int i = 0; i < validStrings.size(); i++) {
            builder.append(validStrings.get((i)));
            if (i + 1 < validStrings.size()) builder.append("/");
        }
        return builder.toString();

    }
    //有限状态机
    private enum State {
        DOT1("读到一个点") {
            @Override
            State next(char c, Context context) {
                if (c == '.') return DOT2;
                if (c == '/') return SEPRA;
                context.addChar('.');
                context.addChar(c);
                return NAME;
            }
        }, DOT2("读到两个点") {
            @Override
            State next(char c, Context context) {
                if (c == '/') {
                    context.removeLast();
                    return SEPRA;
                }
                //文件名，
                context.addChars(new char[]{'.', '.'});
                context.addChar(c);
                return NAME;
            }
        }, SEPRA("读到分隔符") {
            @Override
            State next(char c, Context context) {
                if (c == '/') return SEPRA;
                if (c == '.') return DOT1;
                context.addChar(c);
                return NAME;
            }
        }, NAME("读到普通字符串") {
            @Override
            State next(char c, Context context) {
                if (c == '/') {
                    context.flush();
                    return SEPRA;
                }
                context.addChar(c);
                return NAME;
            }
        }, ERROR("错误") {
            @Override
            State next(char c, Context context) {
                return ERROR;
            }
        };
        State(String desc) {
            this.desc = desc;
        }
        private String desc;
        abstract State next(char c, Context context);

    }

    //记录中间状态，上下文
    private static class Context {
        //存放合法的字符串，最后结果就用这个拼接
        private List<String> strings = new ArrayList<>();
        //字符缓冲区
        private StringBuilder buffer = new StringBuilder();

        public void addChar(char c) {
            buffer.append(c);
        }
        public void addChars(char[] chars) {
            for (char aChar : chars) buffer.append(aChar);
        }
        public void clear() {
            buffer = new StringBuilder();
        }
        public void removeLast() {
            if (strings.size() > 0)
                strings.remove(strings.size() - 1);
        }
        public void flush() {
            if (buffer.length() > 0) {
                strings.add(buffer.toString());
                clear();
            }
        }
        public List<String> getValidStrings() {
            return strings;
        }
    }
}
```