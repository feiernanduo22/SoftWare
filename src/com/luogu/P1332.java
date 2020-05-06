package com.luogu;
import	java.util.LinkedList;
import	java.util.Queue;
import java.io.IOException;
import	java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * P1332 class
 * BFS
 * @auther Yvqanlee
 * @data 2020/4/26 20:18
 */
public class P1332 {
    static int N, M, A, B;
    //记录每个点走到的步骤
    static int[][] DP;
    //记录输出的数组
    static int[][] OutArr;
    static int[] Gx = {1,-1,0,0};
    static int[] Gy = {0,0,1,-1};
    static Queue<Integer> q = new LinkedList<Integer> ();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        A = Integer.valueOf(st.nextToken());
        B = Integer.valueOf(st.nextToken());
        DP = new int[N+1][M+1];
        OutArr = new int[B][2];
        for(int i=0;i<A;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            //起点的DP设为1
            DP[a][b] = 1;
            //并存入队列中
            q.add(a);
            q.add(b);
        }
        for(int i=0;i<B;i++){
            st = new StringTokenizer(bf.readLine());
            OutArr[i][0] = Integer.valueOf(st.nextToken());
            OutArr[i][1] = Integer.valueOf(st.nextToken());
        }

        bfs();
        for(int i=0;i<B;i++){
            System.out.println(DP[OutArr[i][0]][OutArr[i][1]]-1);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            //从队列中取出当前的点
            int x = q.poll();
            int y = q.poll();
            //循环四个方向
            for(int i=0;i<4;i++){
                int a = x + Gx[i];
                int b = y+ Gy[i];
                //如果在范围内且没有使用过
                if(a > 0 && a <= N && b > 0 && b <= M && DP[a][b] == 0){
                    //当前点的DP等于上一点的加1
                    DP[a][b] = DP[x][y] + 1;
                    //新点放入队列中
                    q.add(a);
                    q.add(b);
                }
            }
        }
    }
}
