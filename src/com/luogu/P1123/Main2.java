package com.luogu.P1123;
import java.io.IOException;
import	java.io.InputStreamReader;
import	java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * Main2 class
 *
 * @auther Yvqanlee
 * @data 2020/2/2 12:04
 */
public class Main2 {
    static int M, N, Answer;
    static int[][] Value;
    static int[][] isUsed;
    static int[] Gx = {0,1,1,1,0,-1,-1,-1,0};
    static int[] Gy = {1,1,0,-1,-1,-1,0,1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(st.nextToken());
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.valueOf(st.nextToken());
            N = Integer.valueOf(st.nextToken());
            Value = new int [M] [N];
            isUsed = new int[M][N];
            Answer = 0;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    Value[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            dfs(0, 0, 0, 1);
            System.out.println(Answer);
        }
    }

    static void dfs(int x, int y, int count, int step){
        if(y == N){
            y = 0;
            x++;
            if(x == M){
                Answer = Math.max(Answer, count);
                return;
            }
        }

        if(isUsed [x] [y] == 0){
            dfs(x, y+1, count, step);
        }else{
            bfs(x, y, 0, step);
            dfs(x, y+1, count+Value[x][y], step+1);
            bfs(x, y, step, 0);
            dfs(x, y+1, count, step);
        }
    }

    static void bfs(int x, int y, int ori, int step){
        for(int i=0;i<9;i++){
            int a = x + Gx[i];
            int b = y + Gy[i];
            if(a >= 0 && a < M && b >= 0 && b < N && isUsed[a][b] == ori){
                isUsed[a][b] = step;
            }
        }
    }
}
