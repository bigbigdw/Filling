package com.example.filling.Dongmu;

public class Dongmu_ListData {
    int FoodImg;
    int ImgTag1;
    int ImgTag2;
    int ImgTag3;
    int ImgTag4;
    String Category;
    String Distance;
    String Title;
    String Location;

    public Dongmu_ListData(int FoodImg, String Category, String Distance, String Title, String Location, int ImgTag1, int ImgTag2, int ImgTag3, int ImgTag4) {
        this.FoodImg = FoodImg;
        this.ImgTag1 = ImgTag1;
        this.ImgTag2 = ImgTag2;
        this.ImgTag3 = ImgTag3;
        this.ImgTag4 = ImgTag4;
        this.Category = Category;
        this.Distance = Distance;
        this.Title = Title;
        this.Location = Location;
    }

    public int getFoodImg() {
        return FoodImg;
    }

    public void setFoodImg(int FoodImg) {
        this.FoodImg = FoodImg;
    }

    public int getImgTag1() {
        return ImgTag1;
    }

    public void setImgTag1(int ImgTag1) {
        this.ImgTag1 = ImgTag1;
    }

    public int getImgTag2() {
        return ImgTag2;
    }

    public void setImgTag2(int ImgTag2) {
        this.ImgTag2 = ImgTag2;
    }

    public int getImgTag3() {
        return ImgTag3;
    }

    public void setImgTag3(int ImgTag3) {
        this.ImgTag3 = ImgTag3;
    }

    public int getImgTag4() {
        return ImgTag4;
    }

    public void setImgTag4(int ImgTag4) {
        this.ImgTag4 = ImgTag4;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String Distance) {
        this.Distance = Distance;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
