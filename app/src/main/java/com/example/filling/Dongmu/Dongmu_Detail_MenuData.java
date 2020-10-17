package com.example.filling.Dongmu;


public class Dongmu_Detail_MenuData {
    int ImgLeft;
    int ImgRight;
    String MenuLeft;
    String PriceLeft;
    String MenuRight;
    String PriceRight;

    public Dongmu_Detail_MenuData(int ImgLeft, int ImgRight, String MenuLeft, String PriceLeft, String MenuRight, String PriceRight){
        this.ImgLeft = ImgLeft;
        this.ImgRight = ImgRight;
        this.MenuLeft = MenuLeft;
        this.PriceLeft = PriceLeft;
        this.MenuRight = MenuRight;
        this.PriceRight = PriceRight;
    }

    public int getImgLeft() {
        return ImgLeft;
    }
    public void setImgLeft(int ImgLeft) {
        this.ImgLeft = ImgLeft;
    }

    public int getImgRight() {
        return ImgRight;
    }
    public void setImgRight(int ImgRight) {
        this.ImgRight = ImgRight;
    }

    public String getMenuLeft() {
        return MenuLeft;
    }
    public void setMenuLeft(String MenuLeft) {
        this.MenuLeft = MenuLeft;
    }

    public String getPriceLeft() {
        return PriceLeft;
    }
    public void setPriceLeft(String PriceLeft) {
        this.PriceLeft = PriceLeft;
    }

    public String getMenuRight() {
        return MenuRight;
    }
    public void setMenuRight(String MenuRight) {
        this.MenuRight = MenuRight;
    }

    public String getPriceRight() {
        return PriceRight;
    }
    public void setPriceRight(String PriceRight) {
        this.PriceRight = PriceRight;
    }
}
