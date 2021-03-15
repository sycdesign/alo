package com.jd.visual.algorithm.quicksort.threeways;

import com.jd.visual.algorithm.sharemoney.AlgoVisHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author: gaohongbin5
 * @date: 2020/12/9 16:58:29
 * @description: AlgoFrame
 */
public class AlgoFrame extends JFrame {

  private int canvasWidth;

  private int canvasHeight;

  public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
    super(title);

    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;

    AlgoCanvas canvas = new AlgoCanvas();
    setContentPane(canvas);
    pack();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    setVisible(true);
  }

  public AlgoFrame(String title){
    this(title, 1024, 768);
  }

  public int getCanvasWidth() {
    return canvasWidth;
  }

  public int getCanvasHeight() {
    return canvasHeight;
  }

  private int[] money;

  public void render(int[] money) {
    this.money = money;
    repaint();
  }

  private class AlgoCanvas extends JPanel {

    public AlgoCanvas() {
      super(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D)g;

      //抗锯齿
      RenderingHints hints = new RenderingHints(
              RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
      hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
      g2d.addRenderingHints(hints);

      //具体绘制

      int w = canvasWidth / money.length;
      for (int i = 0; i < money.length; i++) {
        if (money[i] >0){
          AlgoVisHelper.setColor(g2d, Color.BLUE);
          AlgoVisHelper.fillRectangle(g2d,
              i*w + 1, canvasHeight/2-money[i],w-1,money[i]);
        }else if(money[i] <0){
          AlgoVisHelper.setColor(g2d, Color.RED);
          AlgoVisHelper.fillRectangle(g2d,
              i*w + 1, canvasHeight/2,w-1,-money[i]);
        }

      }

    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(canvasWidth,canvasHeight );
    }
  }
}