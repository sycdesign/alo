package com.jd.structures.L09SegmentTree.L03BuildingSegmentTree;

public interface Merger<E> {
  E merge(E a, E b);
}
