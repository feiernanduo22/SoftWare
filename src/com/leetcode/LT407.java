package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LT407 class
 *
 * @auther Yvqanlee
 * @data 2020/6/2 20:40
 */
public class LT407 {
    static int N, M, Answer;
    static boolean[][] isUsed;
    static int[] G = {1,0,-1,0,1};

    static public int trapRainWater(int[][] heightMap){
        if(null == heightMap || heightMap.length == 0){
            return 0;
        }
        //数组的长和宽
        N = heightMap.length;
        M = heightMap[0].length;
        Answer = 0;
        //存放该点是否使用过
        isUsed = new boolean[N][M];
        //优先队列：小的在前
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        //循环所有的点
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                //如果在最外层，则加入队列中，并设为已使用
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    queue.add(new int[]{i, j, heightMap[i][j]});
                    isUsed[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            //从队列中取出
            int[] arr = queue.poll();
            //循环4种方向
            for(int i=0;i<4;i++){
                int x = arr[0] + G[i];
                int y = arr[1] + G[i+1];
                //如果在范围内且未使用过
                if(x >= 0 && x < N && y >= 0 && y < M && !isUsed[x][y]){
                    //如果外层比内层大，则将差加入Answer中
                    if(arr[2] > heightMap[x][y]){
                        Answer += arr[2] - heightMap[x][y];
                    }
                    //设为已访问，加入队列中
                    isUsed[x][y] = true;
                    queue.add(new int[]{x, y, Math.max(arr[2], heightMap[x][y])});
                }
            }
        }
        return Answer;
    }

    public static void main(String[] args) {
        int[][] heightMap = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        System.out.println(trapRainWater(heightMap));
    }
}
