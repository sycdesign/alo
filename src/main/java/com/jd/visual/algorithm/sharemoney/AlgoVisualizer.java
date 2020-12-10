package com.jd.visual.algorithm.sharemoney;

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
  private int[] money;
  private AlgoFrame frame;

  public AlgoVisualizer(int sceneWidth, int sceneHeight) {

    //初始化数据
    money = new int[100];
    for (int i = 0; i < money.length; i++) {
      money[i] = 100;
    }

    //初始化视图
    EventQueue.invokeLater(() -> {
     frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
     new Thread(()->{
       run();
     }).start();
    });
  }

  private  void  run(){

    while (true){
      Arrays.sort(money);
      //绘制数据
      frame.render(money);
      AlgoVisHelper.pause(DELAY);

      for (int k = 0; k < 50; k++) {
        for (int i = 0; i < money.length; i++) {
            int j = (int)(Math.random()*money.length);
            money[i] -=1;
            money[j] +=1;
        }
      }
    }

  }

  private class AlgoKeyListener extends KeyAdapter {

  }

  private class AlgoMouseListener extends MouseAdapter {

  }

  public static void main(String[] args) {

    int sceneWidth = 1000;
    int sceneHeight = 800;

    AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
  }
}
