package com.adv;
import	java.util.HashSet;
import	java.util.LinkedList;
import	java.util.Queue;
import java.io.IOException;
import java.util.Set;
import	java.util.StringTokenizer;
import	java.io.InputStreamReader;

import java.io.BufferedReader;

/**
 * 题目描述及测试用例
 *
 * 在n*n的格子中分别标有0或1，
 * 每次点击其中的一个格子，则该格子及其上下左右四个格子都会变，
 * 给出初始值，给出结束值，
 * 问最少需要点击几次，可以变幻成功？
 * 如果不能变换成功，则返回-1
 *
 * 3
 * 2
 * 0 1
 * 1 0
 * 1 1
 * 1 0
 * 3
 * 1 1 1
 * 1 0 0
 * 1 0 1
 * 0 1 1
 * 0 0 1
 * 1 1 0
 * 4
 * 1 1 0 0
 * 0 1 0 1
 * 1 1 1 1
 * 0 0 0 0
 * 0 1 0 1
 * 1 0 1 0
 * 1 1 0 0
 * 0 0 1 1
 */


/**
 * GeZiZhuanHuan class
 *
 * @auther Yvqanlee
 * @data 2020/3/29 19:07
 */
public class GeZiZhuanHuan {
    /**
     * 格子大小及最终答案
     */
    static int N, Answer;
    /**
     * 初始值
     */
    static String Value1;
    /**
     * 最终结果
     */
    static String Value2;
    static int[] Gx = {1,-1,0,0,0};
    static int[] Gy = {0,0,1,-1,0};
    /**
     * 队列，存放每种格子（转为String类型）
     */
    static Queue<String> queue;
    /**
     * 存放每种情况是否使用过
     */
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.valueOf(st.nextToken());
        for (int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.valueOf(st.nextToken());
            Value1 = "";
            Value2 = "";
            Answer = -1;
            set = new HashSet<String> ();
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for (int j=0;j<N;j++){
                    //将初始数组转为String，方便存储和比较
                    Value1 += st.nextToken();
                }
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    //将最终数组转为String，方便存储和比较
                    Value2 += st.nextToken();
                }
            }
            queue = new LinkedList<String> ();
            //将转换次数和值存入队列中
            queue.add("0");
            queue.add(Value1);
            bfs(queue);
            set.add(Value1);
            System.out.println("#" + t + " " + Answer);
        }
    }

    /**
     * 从队列中取出值，对每个值的每个位置做出转换
     * @param queue
     */
    static void bfs(Queue<String> queue){
        while(!queue.isEmpty()){
            int index = Integer.valueOf(queue.poll());
            if(index > 6){
                queue.clear();
                return;
            }
            String value = queue.poll();
            //将原值深度复制到新的数组中
            char[][] arr = new char[N][N];
            for(int i=0;i<N;i++){
                char[] c = value.substring(i*N, (i+1)*N).toCharArray();
                arr[i] = c;
            }
            //对二位数组的每个位置进行转换
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    changeValue(index, arr, i, j);
                }
            }
        }
    }

    /**
     * 转换二位数组，并且比较是否和最终结果相等
     * @param step 转换次数
     * @param arr  要转换的二位数组
     * @param x    要转换的坐标
     * @param y
     */
    static void changeValue(int step, char[][] arr, int x, int y){
        char[][] newArr = new char[N][N];
        for(int i=0;i<N;i++){
            newArr[i] = arr[i].clone();
        }
        //对本身及上下左右转换
        for(int i=0;i<5;i++){
            int a = x + Gx[i];
            int b = y + Gy[i];
            if(a >= 0 && a < N && b >= 0 && b < N){
                if(newArr[a][b] == '0'){
                    newArr[a][b] = '1';
                }else{
                    newArr[a][b] = '0';
                }
            }
        }
        String newValue = "";
        //将转换后的结果转为String
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newValue += newArr[i][j];
            }
        }
        //判断是否和最终结果相同
        if(newValue.equals(Value2)){
            Answer = step;
            queue.clear();
            return;
        }
        //如果该值没有使用过，则放入队列中
        if(!set.contains(newValue)) {
            queue.add("" + (step + 1));
            queue.add(newValue);
        }
    }
}
