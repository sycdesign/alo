package com.jd.visual.algorithm.quicksort.threeways;

import com.jd.visual.algorithm.quicksort.twoways.TwoWaysQuickSortData;
import com.jd.visual.algorithm.quicksort.twoways.TwoWaysQuickSortData.Type;
import com.jd.visual.algorithm.sharemoney.AlgoFrame;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @author: gaohongbin5
 * @date: 2020/12/9 18:33:52
 * @description: AlgoVisualizer
 */
public class AlgoVisualizer {

  private static final int DELAY = 40;
  private TwoWaysQuickSortData data;
  private AlgoFrame frame;

  public AlgoVisualizer(int sceneWidth, int sceneHeight, int N, Type dataType) {

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
    quickSort3Ways(0, data.N()-1);
  }

  private void setData(int i, int i1, int i2, int i3, int i4, int i5) {
  }

  private void quickSort3Ways(int l, int r){

    if (l > r){
      return;
    }
    if (l == r){
      return;
    }

    int p = (int)(Math.random()* (r-l +1)) + l;
    data.swap(l,p);
    int v = data.get(l);

    //三路快排 partition
    quickSort3Ways(l, p-1);
    quickSort3Ways(p+1, r);

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
