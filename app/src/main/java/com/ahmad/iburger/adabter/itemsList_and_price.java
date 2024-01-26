package com.ahmad.iburger.adabter;

import java.io.Serializable;

public class itemsList_and_price implements Serializable {
    private int img;
    private String item1;
    private String item2;
    private int price1;
    private int price2;

    public itemsList_and_price(int img, String item1, String item2, int price1, int price2) {
        this.img = img;
        this.item1 = item1;
        this.item2 = item2;
        this.price1 = price1;
        this.price2 = price2;
    }

    public int getImg() {
        return this.img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getItem1() {
        return this.item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return this.item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public int getPrice1() {
        return this.price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return this.price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

}
