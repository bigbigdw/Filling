package com.example.filling.Drawer.Alert;

public class Drawer_Alert_ListItem {

    String Contents;
    String Date;
    int resId;

    public Drawer_Alert_ListItem(String Contents, String Date) {
        this.Contents = Contents;
        this.Date = Date;
    }

    public Drawer_Alert_ListItem(String Contents, String Date, int resId) {
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

