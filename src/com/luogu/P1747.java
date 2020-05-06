package com.luogu;
import java.util.LinkedList;
import	java.util.Queue;
import	java.util.Scanner;

/**
 * P1747 class
 *
 * @auther Yvqanlee
 * @data 2020/5/6 20:50
 */
public class P1747 {
    static int x1, y1, x2, y2,;
    //日子形的坐标及田字形的坐标
    static int[] Gx = {1,2,2,1,-1,-1,-2,-2,2,2,-2,-2};
    static int[] Gy = {2,1,-1,-1,2,-2,1,-1,2,-2,2,-2};
    //记录每个点走的步数
    static int[][] DP1 = new int[21][21];
    static int[][] DP2 = new int[21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        //将x、y坐标存入队列中
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(x1);
        q1.add(y1);
        //将起点的步数设为1
        DP1[x1][y1] = 1;
        Queue<Integer> q2 = new LinkedList<> ();
        q2.add(x2);
        q2.add(y2);
        DP2[x2][y2] = 1;
        bfs(q1, DP1);
        bfs(q2, DP2);
    }

    static void bfs(Queue<Integer> q, int[][] dp){
        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            //如果等于1,1,  则输出
            if(x == 1 && y == 1){
                q.clear();
                System.out.println(dp[x][y] - 1);
            }
            //循环12种走法
            for(int i=0;i<12;i++){
                int a = x + Gx[i];
                int b = y + Gy[i];
                //如果在范围内且为走过
                if(a > 0 && a <= 20 && b > 0 && b <= 20 && dp[a][b] == 0){
                    //当前步数 = 上一步 + 1
                    dp[a][b] = dp[x][y] + 1;
                    //将新点放入队列中
                    q.add(a);
                    q.add(b);
                }
            }
        }
    }
}
