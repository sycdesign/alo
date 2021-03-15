package com.jd.lee.j0077;/// Source : https://leetcode.com/problems/combinations/description/
/// Author : liuyubobobo
/// Time   : 2019-04-08

import java.util.ArrayList;
import java.util.List;


/// Using bit mask
/// Time Complexity: O(2^n * n)
/// Space Complexity: O(1)
public class Solution3 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        int LIMIT = (1 << n);
        for(int i = 0; i < LIMIT; i ++){
            List lst = getCombination(i);
            if(lst.size() == k) res.add(lst);
        }
        return res;
    }

    private List getCombination(int num){

        ArrayList<Integer> res = new ArrayList<>();
        int i = 1;
        while (num != 0){
            if(num % 2 == 1) res.add(i);
            i ++;
            num /= 2;
        }
        return res;
    }
    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution3()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
