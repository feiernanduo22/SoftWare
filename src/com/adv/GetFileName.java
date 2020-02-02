package com.adv;

import java.io.File;

/**
 * GetFileName class
 *
 * @auther Yvqanlee
 * @data 2019/12/25 20:27
 */
public class GetFileName {
    public static void main(String[] args) {
        File file = new File("C:/Users/Administrator/Desktop/新建文件夹");
        if (file.isDirectory()){
            File files[] = file.listFiles();
            for (int i=0;i<files.length; i++){
                System.out.println(files[i].getName());
            }
        }
//        System.out.println("杜晶晶");
    }
}
