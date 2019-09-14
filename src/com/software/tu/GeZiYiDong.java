package com.software.tu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

/**
 * GeZiYiDong class
 *
 * @auther Yvqanlee
 * @data 2019/9/11 10:36
 */
public class GeZiYiDong {

    private static int N;
    private static int[][] ARR;
    /**
     * 记录每个位置上的步数
     */
    static int[][] STEP;
    private static int num;
    private static int A, B, C, D;
    /**
     * 定义几种可能移动的策略
     */
    static int[][] group = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int testCase=0;testCase<N;testCase++){
            num = sc.nextInt();
            ARR = new int[num+1][num+1];
            STEP = new int[num+1][num+1];
            for (int i=1;i<=num;i++){
                for (int j=1;j<=num;j++){
                    ARR[i][j] = sc.nextInt();
                    //给每个点的初始值赋为： Integer.MIN_VALUE
                    STEP[i][j] = Integer.MIN_VALUE;
                }
            }
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
            D = sc.nextInt();

            boolean isThrough = false;
            Queue<int[]> queue = new LinkedList<>();
            //将起点放入队列中
            queue.add(new int[]{A, B});
            //给起点的步数置为0
            STEP[A][B] = 0;
            while (!queue.isEmpty()){
                int[] arr = queue.poll();
                int a = arr[0];
                int b = arr[1];
                //如果到达终点，则跳出
                if (a == C && b == D){
                    isThrough = true;
                    break;
                }
                //循环几种移动策略
                for (int i=0;i<group.length;i++){
                    //取出移动后的点的位置
                    int x = group[i][0] + a;
                    int y = group[i][1] + b;
                    //判断移动后的点是否在范围内，且该点可以通过（值为0），且该点的步数为未走过
                    if(x > 0 && x <= num && y > 0 && y <= num && ARR[x][y] == 0 && STEP[x][y] == Integer.MIN_VALUE){
                        //满足条件后将该点放入队列尾部
                        queue.add(new int[]{x, y});
                        //将该点的前一点的步数加1作为该点的步数
                        STEP[x][y] = STEP[a][b] + 1;
                    }
                }
            }
            show(STEP);

            if (isThrough){
                System.out.println("#" + testCase + " " + STEP[C][D]);
            }else {
                System.out.println("#" + testCase + " " + STEP[C][D]);
            }

        }
        sc.close();
    }

    private static void show(int[][] step){
        for (int i=0;i<step.length;i++){
            for (int j=0;j<step[0].length;j++){
                System.out.print(step[i][j]);
            }
            System.out.println();
        }
    }
}
