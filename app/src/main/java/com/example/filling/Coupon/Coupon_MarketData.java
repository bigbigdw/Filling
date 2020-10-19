package com.example.filling.Coupon;

public class Coupon_MarketData {
    int ImgLeft;
    int ImgRight;
    String MarketLeft;
    String NameLeft;
    String PriceLeft;
    String MarketRight;
    String NameRight;
    String PriceRight;

    public Coupon_MarketData(int ImgLeft, int ImgRight, String MarketLeft, String NameLeft, String PriceLeft, String MarketRight, String NameRight, String PriceRight){
        this.ImgLeft = ImgLeft;
        this.ImgRight = ImgRight;
        this.MarketLeft = MarketLeft;
        this.NameLeft = NameLeft;
        this.PriceLeft = PriceLeft;
        this.MarketRight = MarketRight;
        this.NameRight = NameRight;
        this.MarketLeft = MarketLeft;
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

    public String getNameLeft() {
        return NameLeft;
    }
    public void setNameLeft(String NameLeft) {
        this.NameLeft = NameLeft;
    }

    public String getMarketLeft() {
        return MarketLeft;
    }
    public void setMarketLeft(String MarketLeft) {
        this.MarketLeft = MarketLeft;
    }

    public String getPriceLeft() {
        return PriceLeft;
    }
    public void setPriceLeft(String PriceLeft) {
        this.PriceLeft = PriceLeft;
    }

    public String getMarketRight() {
        return MarketRight;
    }
    public void setMarketRight(String MarketRight) {
        this.MarketRight = MarketRight;
    }

    public String getNameRight() {
        return NameRight;
    }
    public void setNameRight(String NameRight) {
        this.NameRight = NameRight;
    }

    public String getPriceRight() {
        return PriceRight;
    }
    public void setPriceRight(String PriceRight) {
        this.PriceRight = PriceRight;
    }
}