package com.luogu.P3956;
import java.util.Comparator;
import	java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Main class
 *
 * @auther Yvqanlee
 * @data 2019/11/29 9:18
 */
public class Main2 {
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

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[4] > o2[4]){
                    return 1;
                }else if(o1[4] < o2[4]){
                    return -1;
                }else{
                    return o1[2] - o2[2];
                }
            }
        };
        Queue<int[]> queue = new PriorityQueue<int[]>(comparator);
        queue.add(new int[]{1, 1, 0, 0, 0});
        isVisited[1][1] = true;
        bfs(queue);
        System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
    }

    static void bfs(Queue<int[]> queue){
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];
            int isTwo = arr[3];
            int step = arr[4];
            if(x == M && y == M){
                Answer = count;
                return;
            }
            int a, b;
            for(int i=0;i<Group.length; i++){
                a = x + Group[i][0];
                b = y + Group[i][1];
                if(a > 0 && a <= M && b > 0 && b <= M && !isVisited[a][b]){
                    if(Value[a][b] != -1 && Value[a][b] == Value[x][y]){
                        isVisited[a][b] = true;
                        queue.add(new int[]{a, b, count, 0, step + 1});
                    }else if(Value[a][b] != -1 && Value[a][b] != Value[x][y]){
                        isVisited[a][b] = true;
                        queue.add(new int[]{a, b, count+1, 0, step + 1});
                    }else if (Value[a][b] == -1 && isTwo == 0){
                        isVisited[a][b] = true;
                        Value[a][b] = Value[x][y];
                        queue.add(new int[]{a, b, count+2, 1, step + 1});
                    }
                }
            }
        }
    }
}
