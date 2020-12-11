package com.jd.visual.algorithm.quicksort.twoways;

import com.jd.visual.algorithm.quicksort.twoways.TwoWaysQuickSortData.Type;
import com.jd.visual.algorithm.sharemoney.AlgoFrame;
import com.jd.visual.algorithm.sharemoney.AlgoVisHelper;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * @author: gaohongbin5
 * @date: 2020/12/9 18:33:52
 * @description: AlgoVisualizer
 */
public class AlgoVisualizer {

  private static final int DELAY = 40;
  private TwoWaysQuickSortData data;
  private AlgoFrame frame;

  public AlgoVisualizer(int sceneWidth, int sceneHeight, int N, TwoWaysQuickSortData.Type dataType) {

    //初始化数据
   data = new TwoWaysQuickSortData(N, sceneHeight, dataType);

    //初始化视图
    EventQueue.invokeLater(() -> {
     frame = new AlgoFrame("Two Ways Quick Sort Visualization", sceneWidth, sceneHeight);
     new Thread(()->{
       run();
     }).start();
    });
  }
  public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
    this(sceneWidth, sceneHeight, N, Type.Default);
  }
  private  void  run(){

    setData(-1, -1, -1, -1, -1, -1);
    quickSort2Ways(0, data.N()-1);
  }

  private void setData(int i, int i1, int i2, int i3, int i4, int i5) {
  }

  private void quickSort2Ways(int l, int r){

    if (l > r){
      return;
    }
    if (l == r){
      return;
    }

    int p = partition(l, r);
    quickSort2Ways(l, p-1);
    quickSort2Ways(p+1, r);

  }

  private int partition(int l, int r) {
    int p = (int)(Math.random()* (r-l +1)) + l;
    data.swap(l,p);
    int v = data.get(l);

    //arr[l+1...i) <= v; arr(j...r] >= v
    int i = l+1,j = r;
    while (true){
      while ( i <= r && data.get(i) < v){
        i++;
      }

      while ( j >= l+1 && data.get(j) > v){
        j--;
      }

      if (i > j){
        break;
      }

      data.swap(i, j);
      i++;
      j--;
    }
    data.swap(l,j);
    return j;
  }


  private class AlgoKeyListener extends KeyAdapter {

  }

  private class AlgoMouseListener extends MouseAdapter {

  }

  public static void main(String[] args) {

    int sceneWidth = 1000;
    int sceneHeight = 800;
    int N = 100;

    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
  }
}
