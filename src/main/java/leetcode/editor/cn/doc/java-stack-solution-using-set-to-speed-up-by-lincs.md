```java
class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (ops.contains(token)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
```
