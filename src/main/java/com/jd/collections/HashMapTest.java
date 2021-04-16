package com.jd.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {
        Map map = new HashMap(10);
        System.out.println(HashMapTest.tableSizeFor(100));

        map.put(null,null);

        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
    }
}
