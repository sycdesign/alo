package com.jd.lee.j0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums)  {

        res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return  res;
        }

        used = new boolean[nums.length];
        Arrays.sort(nums);
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums,0,p);

        return res;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        if (index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i ++){
            if(!used[i]){
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }

                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1,p );

                p.removeLast();
                used[i] = false;
            }
        }
        return;

    }

    public static void printList(List<Integer> list) {
        for (Integer e : list){
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        List<List<Integer>> res = new Main().permuteUnique(nums);
        for (List<Integer> list : res) {
            printList(list);
        }

        System.out.println();

        int[] nums2 = {2,2,1,1};
        List<List<Integer>> res2 = new Main().permuteUnique(nums2);
        for (List<Integer> list : res2) {
            printList(list);
        }

    }
}
