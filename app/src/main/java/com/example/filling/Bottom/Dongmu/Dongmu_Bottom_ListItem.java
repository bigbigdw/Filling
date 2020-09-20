package com.example.filling.Bottom.Dongmu;

public class Dongmu_Bottom_ListItem {

    String Category;
    String Distance;
    String Title;
    String Location;

    int FoodImgresId;
    int ImgTag1resId;
    int ImgTag2resId;
    int ImgTag3resId;
    int ImgTag4resId;

    public Dongmu_Bottom_ListItem(String Category, String Distance, String Title, String Location) {
        this.Category = Category;
        this.Distance = Distance;
        this.Title = Title;
        this.Location = Location;

    }

    public Dongmu_Bottom_ListItem( int FoodImgresId, int ImgTag1resId, int ImgTag2resId, int ImgTag3resId, int ImgTag4resId, String Category, String Distance, String Title, String Location) {
        this.Category = Category;
        this.Distance = Distance;
        this.Title = Title;
        this.Location = Location;

        this.FoodImgresId = FoodImgresId;
        this.ImgTag1resId = ImgTag1resId;
        this.ImgTag2resId = ImgTag2resId;
        this.ImgTag3resId = ImgTag3resId;
        this.ImgTag4resId = ImgTag4resId;
    }

    public int getFoodImgresId() {
        return FoodImgresId;
    }
    public void setFoodImgresId(int FoodImgresId) {
        this.FoodImgresId = FoodImgresId;
    }

    public int getImgTag1resId() {
        return ImgTag1resId;
    }
    public void setImgTag1resId(int ImgTag1resId) {
        this.ImgTag1resId = ImgTag1resId;
    }

    public int getImgTag2resId() {
        return ImgTag2resId;
    }
    public void setImgTag2resId(int ImgTag2resId) {
        this.ImgTag2resId = ImgTag2resId;
    }

    public int getImgTag3resId() {
        return ImgTag3resId;
    }
    public void setImgTag3resId(int ImgTag3resId) {
        this.ImgTag3resId = ImgTag3resId;
    }

    public int getImgTag4resId() {
        return ImgTag4resId;
    }
    public void setImgTag4resId(int ImgTag4resId) {
        this.ImgTag4resId = ImgTag4resId;
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