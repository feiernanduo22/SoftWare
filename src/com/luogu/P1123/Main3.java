package com.luogu.P1123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main2 class
 *
 * @auther Yvqanlee
 * @data 2020/1/13 20:13
 */
public class Main3 {
    static int N, M, Answer;
    static int[][] Value;
    static int[][] DP;
    static int[] Gx = {1,-1,0,0,1,1,-1,-1,0};
    static int[] Gy = {0,0,1,-1,1,-1,1,-1,0};

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
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<M;j++){
                    Value[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            dfs(0, 0, 0, 1);
            System.out.println(Answer);
        }
    }

    static void dfs(int x, int y, int count, int step){
        if(y == M){
            y = 0;
            x++;
            if(x == N){
                Answer = Math.max(Answer, count);
                return;
            }
        }

        if(DP[x][y] > 0){
            dfs(x, y+1, count, step);
        }else{
            bfs(x, y, 1);
            dfs(x, y+1, count+Value[x][y], step+1);
            bfs(x, y, -1);
            dfs(x, y+1, count, step);
        }
    }

    static void bfs(int x, int y, int cnt){
        for(int i=0;i<9;i++){
            int a = x + Gx[i];
            int b = y + Gy[i];
            if(a >= 0 && a < N && b >= 0 && b < M){
                DP[a][b] += cnt;
            }
        }
    }

}
