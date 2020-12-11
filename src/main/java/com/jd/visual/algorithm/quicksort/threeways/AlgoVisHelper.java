package com.jd.visual.algorithm.quicksort.threeways;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

/**
 * @author: gaohongbin5
 * @date: 2020/12/9 18:07:38
 * @description: AlgoVisHelper
 */
public class AlgoVisHelper {
  private AlgoVisHelper(){

  }


  public static void setStrokeWidth(Graphics2D g2d, int width) {
  }

  public static void setColor(Graphics2D g2d, Color color) {
    g2d.setColor(color);
  }

  public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
    Ellipse2D circle = new Double(x-r, y-r, 2*r, 2*r);
    g2d.draw(circle);
  }

  public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
    Ellipse2D circle = new Double(x-r, y-r, 2*r, 2*r);
    g2d.fill(circle);
  }

  public static void pause(int t) {
    try {
      Thread.sleep(t);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void fillRectangle(Graphics2D g2d, int x, int y, int w, int h) {
    Shape shape = new Rectangle2D.Double(x,y,w,h);
    g2d.fill(shape);
  }
}
