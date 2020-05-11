package com.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P1123 class
 * dfs
 * @auther Yvqanlee
 * @data 2020/5/11 20:35
 */
public class P1123_2 {
    static int N, M, Answer;
    static int[][] Value;
    static int[] Gx = {0,1,1,1,0,-1,-1,-1,0};
    static int[] Gy = {1,1,0,-1,-1,-1,0,1,0};
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.valueOf(st.nextToken());
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            Value = new int[N][M];
            DP = new int[N][M];
            Answer = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<M;j++){
                    Value[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            dfs(0, 0, 0);
            System.out.println(Answer);
        }
    }

    /**
     * dfs
     * @param x  开始的坐标
     * @param y
     * @param sum  总值
     */
    static void dfs(int x, int y, int sum){
        if(y == M){
            y = 0;
            x++;
            if(x == N){
                Answer = Math.max(Answer, sum);
                return;
            }
        }
        if(DP[x][y] > 0){
            dfs(x, y+1, sum);
        }else{
            bfs(x, y, 1);
            dfs(x, y+1, sum+Value[x][y]);
            bfs(x, y, -1);
            dfs(x, y+1, sum);
        }
    }

    static void bfs(int x, int y, int index){
        for(int i=0;i<9;i++){
            int a = x + Gx[i];
            int b = y + Gy[i];
            if(a >= 0 && a < N && b >= 0 && b < M){
                DP[a][b] = DP[a][b] + 1*index;
            }
        }
    }
}
