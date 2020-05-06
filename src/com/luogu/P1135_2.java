package com.luogu;
import	java.util.LinkedList;
import java.util.Queue;
import	java.util.Scanner;

/**
 * P1135_2 class
 *
 * @auther Yvqanlee
 * @data 2020/5/3 18:00
 *
 * bfs
 */
public class P1135_2 {
    static int N, A, B, Answer;
    static int[] Arr;
    static boolean [] isUsed;
    static int[] g = {1, -1};
    static Queue<Integer> queue = new LinkedList<Integer> ();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        Answer = Integer.MAX_VALUE;
        Arr = new int[N+1];
        isUsed = new boolean [N+1];
        for(int i=1;i<=N;i++){
            Arr[i] = sc.nextInt();
        }
        //将运行次数和楼层数加入队列中
        queue.add(0);
        queue.add(A);
        bfs();
        System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
    }

    /**
     * 获得最少次数
     */
    static void bfs(){
        //如果队列不为空
        while(!queue.isEmpty()){
            //取出次数和起始楼层
            int count = queue.poll();
            int start = queue.poll();
            //判断该楼层是否为最终楼层
            if(start == B){
                //如果是，则将次数赋给答案，清空队列
                Answer = count;
                queue.clear();
                return;
            }
            //循环两个方向
            for(int i=0;i<=1;i++){
                //获得运行后的楼层
                int end = start + Arr[start]*g[i];
                //如果在范围内且没有使用过
                if(end >= 1 && end <= N && !isUsed[end]){
                    //置为使用过
                    isUsed[end] = true;
                    //使用次数+1放入队列，结果放入队列
                    queue.add(count+1);
                    queue.add(end);
                }
            }
        }
    }
}
