package com.jd.visual.algorithm.quicksort.twoways;

/**
 * @author: gaohongbin5
 * @date: 2020/12/11 13:45:45
 * @description: TwoWaysQuickSortData
 */
public class TwoWaysQuickSortData {

  public enum Type{
    Default,
    NearlyOrdered,
    Identical
  }

  private int[] numbers;
  public int l, r;
  public boolean[] fixedPivots;
  public int curPivot;
  public int curL, curR;

  public TwoWaysQuickSortData(int N, int randomBound, Type dataType){



  }

  public int N() {
    return numbers.length;
  }

  public void swap(int l, int p) {
  }

  public int get(int l) {
    return 0;
  }
}
