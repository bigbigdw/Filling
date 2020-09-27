package com.example.filling.Myinfo;

public class MyCoupon_ListItem {

    String Title;
    String GoodsName;
    String Date;

    int ImageId;

    public MyCoupon_ListItem(String Title, String Date, String GoodsName) {
        this.Title = Title;
        this.GoodsName = GoodsName;
        this.Date = Date;
    }

    public MyCoupon_ListItem(String Title, String GoodsName, String Date, int ImageId) {
        this.Title = Title;
        this.GoodsName = GoodsName;
        this.Date = Date;

        this.ImageId = ImageId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String GoodsName) {
        this.GoodsName = GoodsName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int ImageId) {
        this.ImageId = ImageId;
    }
}
