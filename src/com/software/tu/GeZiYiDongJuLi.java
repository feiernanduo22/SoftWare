package com.software.tu;
/**
 * 判断格子中两点是否可相连，如果可到达，显示出需要几步
 * bsf算法
 * 测试数据
 * 1
 * 3
 * 0 1 0
 * 0 0 1
 * 1 0 0
 * 1 1 3 3
 */

import java.util.Scanner;

/**
 * GeZiYiDongJuLi class
 *
 * @auther Yvqanlee
 * @data 2019/9/11 11:50
 */
public class GeZiYiDongJuLi {
    private static int N;
    private static int[][] ARR;
    /**
     * 记录每个位置是否已走过
     */
    static int[][] VALUE;
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
            VALUE = new int[num + 1][num + 1];
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    ARR[i][j] = sc.nextInt();
                    //给每个点的初始值赋为： -65535
                }
            }
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
            D = sc.nextInt();

            VALUE[A][B] = 1;
            dsf(A, B, 0);
            System.out.println("最短距离:" + shortPath);
        }
        sc.close();
    }

    private static void dsf(int x, int y, int step){
        if (x == C && y == D){
            if (shortPath > step){
                shortPath = step;
            }
        }
        for (int i=0;i<group.length;i++){
            int a = x + group[i][0];
            int b = y + group[i][1];
            if (a > 0 && a <= num && b > 0 && b <= num && ARR[a][b] == 0 && VALUE[a][b] != 1){
                VALUE[a][b] = 1;
                dsf(a, b, step + 1);
                VALUE[a][b] = 0;
            }
        }
    }
}
