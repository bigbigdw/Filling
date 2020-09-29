package com.example.filling.Myinfo;

public class Cash_Report_ListItem {

    String Name;
    String Date;
    String Count;
    String Rest;
    int ImgID;

    public Cash_Report_ListItem(String Name, String Date, String Count, String Rest) {
        this.Name = Name;
        this.Date = Date;
        this.Count = Count;
        this.Rest = Rest;
    }

    public Cash_Report_ListItem(String Name, String Date, String Count,String Rest, int ImgID) {
        this.Name = Name;
        this.Date = Date;
        this.Count = Count;
        this.ImgID = ImgID;
        this.Rest = Rest;
    }

    public int getImgID() {
        return ImgID;
    }
    public void setImgID(int ImgID) {
        this.ImgID = ImgID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getCount() {
        return Count;
    }
    public void setCount(String Count) {
        this.Count = Count;
    }

    public String getRest() {
        return Rest;
    }
    public void setRest(String Rest) {
        this.Rest = Rest;
    }

}

