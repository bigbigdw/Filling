package com.example.filling.Bottom.Filling;

public class Bottom_Filling_ListItem {

    String Contents;
    String Date;
    int resId;

    public Bottom_Filling_ListItem(String Contents, String Date) {
        this.Contents = Contents;
        this.Date = Date;
    }

    public Bottom_Filling_ListItem(String Contents, String Date, int resId) {
        this.Contents = Contents;
        this.Date = Date;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String Contents) {
        this.Contents = Contents;
    }
}
