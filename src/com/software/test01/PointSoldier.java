package com.software.test01;

/**
 * @auther Yvqanlee
 * @data 2019/5/27 22:00
 */
public class PointSoldier {
    public static void main(String[] args) {
        //最大人数
        final int MAXPEOPLE = 100;
        int a,b,c = 0;
        for (int i=0;i<MAXPEOPLE;i++){
            a = i % 3;
            b = i % 7;
            c = i % 5;
            if (a == 1 && b == 5 && c == 0){
                System.out.println("共有：" + i + "人");
            }
        }
    }
}
