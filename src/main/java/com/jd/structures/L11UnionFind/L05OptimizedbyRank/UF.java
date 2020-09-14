package com.jd.structures.L11UnionFind.L05OptimizedbyRank;

public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
