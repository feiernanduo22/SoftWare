package com.software.tu;

/**
 * 给出起点后，病毒会每天一格的速度蔓延，求出生存时间最长的星球及生存的时间
 *
 * 测试用例
 * 1
 * 8 9
 * 1 5
 * 5 2
 * 2 4
 * 4 8
 * 1 7
 * 7 2
 * 7 3
 * 3 6
 * 6 8
 *
 * bsf
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * TaoLiHuoXing class
 *
 * @auther Yvqanlee
 * @data 2019/9/14 10:40
 */
public class TaoLiHuoXing {
    /**
     * 测试用例的个数
     */
    static int N;
    /**
     * p代表：星球个数，L代表线路个数
     */
    static int P, L;
    /**
     * 线路信息
     */
    static int[][] arr;

    /**
     * 到达该点的步数
     */
    static int[] step;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int testCase = 0;testCase<N;testCase++){
            P = scanner.nextInt();
            L = scanner.nextInt();
            arr = new int[L+1][2];
            step = new int[P+1];
            //将点之间的联系记录在二位数组中
            for (int i=0;i<L;i++){
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            step[1] = 1;
            while (!queue.isEmpty()){
                int root = queue.poll();
                for(int i=0;i<=L;i++){
                    if (arr[i][0] == root && step[arr[i][1]] == 0){
                        queue.add(arr[i][1]);
                        step[arr[i][1]] = step[arr[i][0]] + 1;
                    }
                    if(arr[i][1] == root && step[arr[i][0]] == 0){
                        queue.add(arr[i][0]);
                        step[arr[i][0]] = step[arr[i][1]] + 1;
                    }
                }
            }
            int maxLength = 0;
            for (int i=0;i<=P;i++){
                if (maxLength < step[i]){
                    maxLength = step[i];
                }
            }
            System.out.println("#" + testCase + " " + (maxLength-1));

        }
        scanner.close();
    }
}
