package com.jd.visual.algorithm;

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

  private Object data;

  public void render(Object data) {
    this.data = data;
    repaint();
  }

  private class AlgoCanvas extends JPanel {



    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;

      //抗锯齿
      RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      g2d.addRenderingHints(hints);

      //具体绘制
      AlgoVisHelper.setStrokeWidth(g2d, 1);
      AlgoVisHelper.setColor(g2d, Color.RED);
      int x = 50;
      int y = 50;
      int r = 20;
      AlgoVisHelper.strokeCircle(g2d, x, y, r);
      AlgoVisHelper.fillCircle(g2d, x, y, r);
      AlgoVisHelper.pause(5);

    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(canvasWidth,canvasHeight );
    }
  }
}
