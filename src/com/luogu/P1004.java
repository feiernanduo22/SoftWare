package com.luogu;
import	java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P1004 class
 *
 * @auther Yvqanlee
 * @data 2020/4/15 20:11
 */
public class P1004 {
    static int N, Answer;
    static int[][] Value;
    static int[][][][] DP;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Value = new int[11][11];
        DP = new int[11][11][11][11];
        Answer = 0;
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 0 && y == 0){
                break;
            }
            int val = sc.nextInt();
            Value[x][y] = val;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    for(int l=1;l<=N;l++){
                        DP[i][j][k][l] = Math.max(DP[i-1][j][k-1][l], Math.max(DP[i-1][j][k][l-1],
                            Math.max(DP[i][j-1][k-1][l], DP[i][j-1][k][l-1]))) + Value[i][j] + Value[k][l];
                        if(i == k && j == l){
                            DP[i][j][k][l] -= Value[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(DP[N][N][N][N]);
    }
}
