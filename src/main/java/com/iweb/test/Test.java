package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/24 22:52
 */
import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("编写一个程序输出指定路径下的所有文件");
        System.out.println("输入：");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());
        System.out.println("结果出来了");
        swap(f);
    }
    public static void swap(File f){
        if(f.isFile()){
            printFile(f);
        } else if (f.isDirectory()) {
            printDirectory(f);
        }else {
            System.out.println("你输入的格式不正确");
        }
    }
    public static void printFile(File f){
        System.out.println(f.getAbsolutePath());
    }
    public static void printDirectory(File f){
        File[] files = f.listFiles();
        for (File file:files){
            swap(file);
        }
    }
}