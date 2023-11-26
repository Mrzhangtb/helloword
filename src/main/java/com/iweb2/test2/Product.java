package com.iweb2.test2;/*
 * @author Zhang
 * @date 2023/11/25 10:43
 */

public class Product {
    private Integer id;
    private String name;
    private Float price;
    public void sell(){
        System.out.println(name+"jj"+price+"jjy");
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
