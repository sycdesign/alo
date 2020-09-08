package com.jd.lee.L10GreedyAlgorithms;

import java.util.Arrays;

/**
 * @author: gaohongbin5
 * @date: 2020/9/7 10:53:41
 * @description: Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Math.pow(2D,13D));
        Integer[] array = Util.generateRandomArray(1 << 13 + 1,0,200);
        Arrays.sort(array);
        Arrays.parallelSort(array);
        for (Integer in : array) {
            System.out.println(in);
        }
    }
}
