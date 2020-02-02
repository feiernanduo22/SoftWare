package com.luogu.P1123;
import java.util.Scanner;

/**
 * Main class
 *
 * @auther Yvqanlee
 * @data 2019/11/30 21:13
 */

public class Main {
    static int N, M, Answer;
    static int[][] Value;
    static int[][] DP;
    static int[][] Group = {{-1,-1},{-1,0},{-1,1},{0,1},{0,0},{1,1},{1,0},{1,-1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            Value = new int[N][M];
            DP = new int[N][M];
            Answer = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    Value[i][j] = sc.nextInt();
                }
            }
            dfs(0,0,0,1);
            System.out.println(Answer);
        }
        sc.close();
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
            int a, b;
            for(int i=0;i<Group.length;i++){
                a = x + Group[i][0];
                b = y + Group[i][1];
                if(a >= 0 && a < N && b >= 0 && b < M && DP[a][b] == 0){
                    DP[a][b] = step;
                }
            }
            dfs(x, y+1, count+Value[x][y], step+1);
            for(int i=0;i<Group.length; i++){
                a = x + Group [i] [0];
                b = y + Group[i][1];
                if(a >= 0 && a < N && b >= 0 && b < M && DP[a][b] == step){
                    DP[a][b] = 0;
                }
            }
            dfs(x, y+1, count, step);
        }
    }
}

