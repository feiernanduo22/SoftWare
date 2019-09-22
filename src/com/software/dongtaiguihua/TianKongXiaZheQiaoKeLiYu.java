package com.software.dongtaiguihua;

/**
 * 每次向上移动格子，同时左右移动一格，两格，三格（只能移动一次），求最大的金币数
 *
 * 回溯
 *
 * 测试用例
 * 2
 * 4 4
 * 6 0 0 3
 * 0 0 5 3
 * 4 1 0 0
 * 0 0 0 0
 * 5 4
 * 9 0 2 1 6
 * 2 4 1 1 8
 * 0 3 0 5 0
 * 9 0 2 7 2
 * 0 0 0 0 0
 */

import java.util.Scanner;

/**
 * TianKongXiaZheQiaoKeLiYu class
 *
 * @auther Yvqanlee
 * @data 2019/9/22 20:35
 */
public class TianKongXiaZheQiaoKeLiYu {
    /**
     * N: 测试用例数
     * R： 行列数
     * M： 起点的列数
     */
    static int N,R,M;
    /**
     * 每个格子的值
     */
    static int[][] value;
    /**
     * 记录每个格子的最大值
     */
    static int[][] value2;
    static int[][] value3;

    static int maxValue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int testCase = 1; testCase <= N; testCase++) {
            R = scanner.nextInt();
            M = scanner.nextInt();
            value = new int[R+1][R+1];
            value2 = new int[R+1][R+1];
            value3 = new int[R+1][R+1];
            maxValue = Integer.MIN_VALUE;

            for (int i=1;i<=R;i++){
                for (int j = 1;j <= R; j++){
                    value[i][j] = scanner.nextInt();
                }
            }

            dsf(R, M, false, 0);
            System.out.println("#" + testCase + " " + maxValue);
        }
    }

    private static void dsf(int x, int y, boolean isThree, int step){
        step += value[x][y];
        if(value2 [x][y] <= step && isThree){
            value2[x][y] = step;
        }else if(value3[x][y] <= step && !isThree){
            value3 [x] [y] = step;
        }


        if (x == 1){
            if (maxValue <= step){
                maxValue = step;
            }
            return;
        }

        if(value3[x][y] <= step && !isThree){
            int min = y - 3 >= 0 ? y - 3 : 0;
            int max = y + 3 <= R ? y + 3 : R;
            for (int i=min;i<=max;i++){
                if (i == min || i == max){
                    dsf(x-1, i, true, step);
                }else if(i != min && i != max){
                    dsf(x-1, i, isThree, step);
                }
            }
        }else if(value2[x][y] <= step && isThree){
            int min = y - 2 >= 0 ? y - 2 : 0;
            int max = y + 2 <= R ? y + 2 : R;
            for (int i = min; i <= max; i++){
                dsf(x-1, i, isThree, step);
            }
        }
    }
}
