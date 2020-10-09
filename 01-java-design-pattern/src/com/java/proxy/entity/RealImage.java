package com.java.proxy.entity;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        this.loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("图片显示："+fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("图片从磁盘加载"+fileName);
    }
}
