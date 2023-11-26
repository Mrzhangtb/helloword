package com.iweb.test;/*
 * @author Zhang
 * @date 2023/11/24 23:10
 */

import java.io.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("编写一个程序用于文件的拷贝");
        System.out.println("输入要复制的目标：");
        Scanner sc = new Scanner(System.in);
        File from = new File(sc.nextLine());
        System.out.println("输入拷贝到的具体路径");
        File to = new File(sc.nextLine());
        if(to.isFile() || !to.exists()){
            System.out.println("输入的格式有误，拷贝路径错误");
        } else if (from.getAbsolutePath() == to.getAbsolutePath()) {
            System.out.println("错误");
        }else {
            swap(from,to);
        }
    }
    public static void swap(File from,File to){
        if (from.isFile()) {
            copFile(from,to);
        } else if (from.isDirectory()) {
            copDirectory(from,to);
        }else {
            System.out.println("输入的格式有误，文件不存在");
        }
    }
    public static void copFile(File from,File to){
        File newTo = new File(to.getAbsolutePath()+"/"+from.getName());
        try {
            newTo.createNewFile();
            FileInputStream fis = new FileInputStream(from);
            FileOutputStream fos = new FileOutputStream(newTo, true);
            byte[] all = new byte[(int)from.length()];
            fis.read(all);
            fos.write(all);
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void copDirectory(File from,File to){
        File[] files = from.listFiles();
        File newTo = new File(to.getAbsolutePath()+"/"+from.getName());
        newTo.mkdirs();
        for (File file:files){
            swap(file,newTo);
        }
    }
}