package algorithms.edouardb;

import algorithms.edouardb.struct.Heap;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[50];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100 + 1);
        }
        Heap heap = new Heap(array);
        int[] ret = heap.heapSort();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++) {
            sb.append(ret[i] + ",");
        }
        System.out.println(sb.toString());
    }
}
