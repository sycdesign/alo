package com.jd.zuo.offer.class01;

public class CordCoverMaxPoint {
    public static int maxPoint1(int[] arr,int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res,i - nearest + 1);
        }
        return res;
    }

    private static int nearestIndex(int[] arr, int R, int value) {
        return 0;
    }
}
