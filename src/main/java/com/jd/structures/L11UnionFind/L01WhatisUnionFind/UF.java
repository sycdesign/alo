package com.jd.structures.L11UnionFind.L01WhatisUnionFind;

public interface UF {

  int getSize();

  boolean isConnected(int p, int q);

  void unionElements(int p, int q);
}
