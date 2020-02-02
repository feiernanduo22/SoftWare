package com.software.tu;

import java.util.Scanner;

/**
 * GeZiYiDongJuLi3 class
 *
 * @auther Yvqanlee
 * @data 2019/10/8 21:35
 */
public class GeZiYiDongJuLi3 {
    private static int N;
    private static int[][] ARR;
    /**
     * 记录每个位置是否已走过
     */
    static boolean[][] isUsed;
    private static int num;
    private static int A, B, C, D;
    /**
     * 定义几种可能移动的策略
     */
    static int[][] group = {{1,0},{-1,0},{0,1},{0,-1}};
    /**
     * 初始化最短距离
     */
    static int shortPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int testCase=0;testCase<N;testCase++) {
            num = sc.nextInt();
            ARR = new int[num + 1][num + 1];
            isUsed = new boolean[num + 1][num + 1];
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    ARR[i][j] = sc.nextInt();
                }
            }
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
            D = sc.nextInt();

            isUsed[A][B] = true;
            dsf(A, B, 0);
            System.out.println("最短距离:" + shortPath);
        }
        sc.close();
    }

    private static void dsf(int x, int y, int step){
        if(x == C && y == D){
            shortPath = Math.min(shortPath, step);
        }

        for(int i=0;i<group.length;i++){
            int a = x + group[i][0];
            int b = y + group [i] [1];
            if(a >= 0 && a < N && b >= 0 && b < N && !isUsed[a][b] && ARR[a][b] == 0){
                isUsed[x][y] = true;
                dsf(a, b, step + 1);
                isUsed [x] [y] = false;
            }
        }
    }

}
