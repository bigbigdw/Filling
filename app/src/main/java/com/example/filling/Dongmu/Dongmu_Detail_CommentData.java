package com.example.filling.Dongmu;

public class Dongmu_Detail_CommentData {
    String Name;
    String ID;
    String Date;
    String Text;

    int ImgNameId;

    public Dongmu_Detail_CommentData( int ImgNameId,  String Name, String ID, String Date, String Text) {
        this.Name = Name;
        this.ID = ID;
        this.Date = Date;
        this.Text = Text;
        this.ImgNameId = ImgNameId;
    }

    public int getImgNameId() {
        return ImgNameId;
    }
    public void setImgNameId(int FoodImgresId) {
        this.ImgNameId = FoodImgresId;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getText() {
        return Text;
    }
    public void setText(String Text) {
        this.Text = Text;
    }
}
