package com.luogu;
import	java.util.Scanner;

/**
 * P1135 class
 *
 * @auther Yvqanlee
 * @data 2020/5/3 17:22
 *
 * dfs
 */
public class P1135 {
    static int N, A, B, Answer;
    /**
     * 存放每层楼能到达的位置
     */
    static int[] Arr;
    /**
     * 存放楼层是否使用过
     */
    static boolean[] isUsed;
    /**
     * 存放运行的方向
     */
    static int[] g = {1, -1};
    /**
     * 存放到达该楼层的最少次数
     */
    static int[] Value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        Arr = new int[N+1];
        isUsed = new boolean [N+1];
        Value = new int [N+1];
        //到达每层楼的最少次数初始化为最大值
        for(int i=0;i<=N;i++){
            Value[i] = Integer.MAX_VALUE;
        }
        //结果初始化为最大值
        Answer = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            Arr[i] = sc.nextInt();
        }
        dfs(A, 0);
        System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
    }

    /**
     * 获得最少次数
     * @param start  开始的楼层
     * @param count  运行的次数
     */
    static void dfs(int start, int count){
        //如果开始楼层 = 最终楼层
        if(start == B){
            //取出结果较小的
           Answer = Math.min(Answer, count);
           return;
        }

        //如果到达该楼层的最少次数 > 当前运行次数
        if(count < Value [start]){
            //将当前运行次数 赋给 到达该楼层的最少次数
            Value [start] = count;
        }else{
            return;
        }

        //遍历运行方向
        for(int i=0;i<=1;i++){
            //运行后到达楼层 = 当前楼层 + 运行的楼层
            int end = start + Arr[start]*g[i];
            //如果在范围内且没有使用过
            if(end >= 1 && end <= N && !isUsed [end]){
                //置为使用过
                isUsed [start] = true;
                //将到达的楼层作为新的起始楼层， 运行次数 + 1
                dfs(end, count+1);
                //回溯
                isUsed [start] = false;
            }
        }
    }
}
