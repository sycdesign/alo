package com.jd.lee.L06StackandQueue.L01ValidParentheses;

import java.util.Stack;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/
// 时间复杂度: O(n)
// 空间复杂度: O(n)

/**
 * 相类似问题 150
 * 71
 */
public class Solution {

  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
      else {

        if (stack.size() == 0) return false;

        Character c = stack.pop();

        Character match;
        if (s.charAt(i) == ')') match = '(';
        else if (s.charAt(i) == ']') match = '[';
        else {
          assert s.charAt(i) == '}';
          match = '{';
        }

        if (c != match) return false;
      }

    if (stack.size() != 0) return false;

    return true;
  }

  private static void printBool(boolean b) {
    System.out.println(b ? "True" : "False");
  }

  public static void main(String[] args) {

    printBool((new Solution()).isValid("()"));
    printBool((new Solution()).isValid("()[]{}"));
    printBool((new Solution()).isValid("(]"));
    printBool((new Solution()).isValid("([)]"));
  }
}
