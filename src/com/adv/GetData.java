package com.adv;

/**
 * GetData class
 *
 * @auther Yvqanlee
 * @data 2019/12/21 23:20
 */
public class GetData {
    public static void main(String[] args) {
        System.out.println("30");
        for(int k=1;k<=30;k++){
            System.out.println("10 10");
            for(int i=1;i<=20;i++){
                for(int j=1;j<=10;j++){
                    System.out.print(Math.round(Math.random() * 100) + " ");
                }
                System.out.println();
            }
        }
    }
}
