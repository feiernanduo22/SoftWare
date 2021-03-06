package com.software.tu;
/**
 * 找出路线上可以获得的最多的金币数量
 * 每次如果向左或向右移动一格，则必须向上移动一格；
 * 每次如果向左或向右移动两格，则必须向上移动两格；
 *
 * dsf
 *
 * 特别注意：如果每次都向上或向下移动，则不用记录该点是否走过
 *          定义数组存放该位置上的最大步数，用于判断是否需继续往下走，减少遍历的次数
 *
 * 测试用例：
 *
 *  * 1
 *  * 1 3 10
 *  * 1 1 0 1 1 1 0 1 3 0
 *  * 0 2 1 1 1 1 0 1 0 0
 *  * 1 1 0 1 0 2 1 0 0 1
 */

import java.util.Scanner;

/**
 * ZhaoJinBi class
 *
 * @auther Yvqanlee
 * @data 2019/9/14 11:51
 */
public class ZhaoJinBi {
    /**
     * 测试用例个数
     */
    static int N;
    /**
     * S:每次移动的步数
     * R：行数
     * C：列数
     */
    static int S, R, C;
    static int[][] value;
    static int maxValue;
    /**
     * 格子移动策略
     */
    static int[][] group;
    /**
     * 记录当前格子存放的最大值
     */
    static int[][] allValue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int testCase = 0; testCase < N; testCase++){
            S = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            maxValue = Integer.MIN_VALUE;
            value = new int[R+1][C+1];
            allValue = new int [R+1] [C+1];
            if (S == 1){
                group = new int[][]{{-1,1},{0,1},{1,1}};
            }else if(S == 2){
                group = new int[][]{{-2,2},{-1,1},{0,1},{1,1},{2,2}};
            }

            for (int i=1;i<=R;i++){
                for (int j = 1;j <= C; j++){
                    value[i][j] = scanner.nextInt();
                }
            }

            int finalValue = Integer.MIN_VALUE;
            //动态初始起点，获得不能起点下的金币数量
            for (int i=1;i<=3;i++){
                dsf(i, 1, value[i][1]);
                if(finalValue < maxValue){
                    finalValue = maxValue;
                }
            }
            System.out.println("#" + testCase + " " + finalValue);

        }
        scanner.close();
    }

    private static void dsf(int x, int y, int step){
        //循环终止条件：当y到达最大值：10的时候
        if (y == 10){
            if (maxValue < step){
                maxValue = step;
            }
        }

        for (int i=0;i<group.length;i++){
            int a = x + group[i][0];
            int b = y + group[i][1];
            //如果当前步数和大于等于该位置最大值，则继续往下循环，且将该位置最大值置为当前的步数和
            if (a > 0 && a <= 3 && b > 0 && b <= 10 && allValue[a][b] <= step){
                allValue[a][b] = step;
                dsf(a, b, step + value[a][b]);
            }
        }
    }
}
