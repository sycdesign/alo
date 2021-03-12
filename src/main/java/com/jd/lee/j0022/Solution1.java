package com.jd.lee.j0022;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0 ,0, n);
        return ans;
    }

    private void helper(List<String> ans, String str, int open, int close, int max) {
        if (str.length() == 2* max){
            ans.add(str);
            return;
        }

        if (open < max){
            helper(ans,str + "(",open+1,close,max);
        }

        if (close < open){
            helper(ans, str + ")",open,close +1 ,max);
        }


    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = (new Solution1()).generateParenthesis(n);
        printList(res);
    }

    private static void printList(List<String> res) {
        for (String r : res) {
            System.out.println(r + " ");
        }
        System.out.println();
    }
}
