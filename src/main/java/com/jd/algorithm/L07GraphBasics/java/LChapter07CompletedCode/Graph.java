package com.jd.algorithm.L07GraphBasics.java.LChapter07CompletedCode;

// 图的接口
public interface Graph {

  public int V();

  public int E();

  public void addEdge(int v, int w);

  boolean hasEdge(int v, int w);

  void show();

  public Iterable<Integer> adj(int v);
}
