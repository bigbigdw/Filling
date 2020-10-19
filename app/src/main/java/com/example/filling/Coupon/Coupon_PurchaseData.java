package com.example.filling.Coupon;

public class Coupon_PurchaseData {
    int Img;
    String Market;
    String Name;
    String Price;
    String Count;

    public Coupon_PurchaseData(int Img, String Market, String Name, String Price, String Count){
        this.Img = Img;
        this.Market = Market;
        this.Name = Name;
        this.Price = Price;
        this.Count = Count;

    }

    public int getImg() {
        return Img;
    }
    public void setImg(int Img) {
        this.Img = Img;
    }

    public String getMarket() {
        return Market;
    }
    public void setMarket(String Market) {
        this.Market = Market;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getCount() {
        return Count;
    }
    public void setCount(String Count) {
        this.Count = Count;
    }

}
