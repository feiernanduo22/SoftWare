package com.luogu.P3956;
import java.util.Comparator;
import java.util.PriorityQueue;
import	java.util.Queue;

/**
 * PriorityQueueExample class
 *
 * @auther Yvqanlee
 * @data 2019/11/30 20:04
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] > o2[2]){
                    return 1;
                }else if(o1[2] < o2[2]){
                    return -1;
                }else{
                    return o1[3] - o2[3];
                }
            }
        };

        Queue<int[]> queue = new PriorityQueue<>(c);
        queue.add(new int[]{1,1,0, 3});
        queue.add(new int[]{2,2,0, 2});
        queue.add(new int[]{1,2,1, 6});
        queue.add(new int[]{4,4,1, 3});
        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            System.out.println(arr[2] + " " + arr[3]);
        }
    }
}
