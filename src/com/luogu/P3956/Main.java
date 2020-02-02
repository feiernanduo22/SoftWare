package com.luogu.P3956;
import java.util.Scanner;

/**
 * dfs
 * pass
 */

/**
 * Main class
 *
 * @auther Yvqanlee
 * @data 2019/11/29 9:18
 */
public class Main {
    static int M, N, Answer;
    static int[][] Value;
    static int[][] Group = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisited;
    static int[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        Answer = Integer.MAX_VALUE;
        Value = new int [M+1][M+1];
        DP = new int[M+1][M+1];
        isVisited = new boolean [M+1][M+1];
        for(int i=0;i<=M;i++){
            for(int j=0;j<=M;j++){
                Value [i] [j] = -1;
            }
        }
        int a, b, c;
        for (int i=0;i<N;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            Value [a] [b] = c;
        }

        isVisited[1][1] = true;

        dfs(1, 1, 0, false);
        System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
    }

    static void dfs(int x, int y, int count, boolean isTwo){
        if(count > Answer){
            return;
        }
        if(DP[x][y] != 0 && count >= DP[x][y]){
            return;
        }
        DP[x][y] = count;
        if (x == M && y == M){
            Answer = Math.min(Answer, count);
            return;
        }

        int a, b;
        for(int i=0;i<Group.length; i++){
            a = x + Group[i][0];
            b = y + Group[i][1];
            if(a > 0 && a <= M && b > 0 && b <= M && !isVisited[a][b]){
                isVisited[a][b] = true;
                if(Value[a][b] != -1 && Value[a][b] == Value[x][y]){
                    dfs(a, b, count, false);
                }else if(Value[a][b] != -1 && Value[a][b] != Value[x][y]){
                    dfs(a, b, count+1, false);
                }else if(Value[a][b] == -1 && !isTwo){
                    Value[a][b] = Value[x][y];
                    dfs(a, b, count+2, true);
                    Value[a][b] = -1;
                }
                isVisited [a] [b] = false;
            }
        }
    }

}
