package com.luogu.P1506;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Main class
 *
 * @auther Yvqanlee
 * @data 2019/12/1 20:46
 */
public class Main {
    static int M, N, Answer;
    static char[][] Value;
    static int[][] Group = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        Value = new char[M] [N];
        for(int i=0;i<M;i++){
            Value[i] = sc.next().toCharArray();
        }

        Queue<Integer> queue = new LinkedList<Integer> ();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if((i == 0 || i == M-1 || j == 0 || j == N-1) && Value [i] [j] == '0'){
                    Value[i][j] = '*';
                    queue.clear();
                    queue.add(i);
                    queue.add(j);
                    bfs(queue);
                }
            }
        }

        for(int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if(Value[i][j] == '0'){
                    Answer++;
                }
            }
        }
        System.out.println(Answer);

    }

    static void bfs(Queue<Integer> queue){
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i=0;i<Group.length;i++){
                int a = x + Group [i][0];
                int b = y + Group [i][1];
                if(a >= 0 && a < M && b >= 0 && b < N && Value[a][b] == '0'){
                    Value [a][b] = '*';
                    queue.add(a);
                    queue.add(b);
                }
            }
        }
    }
}
