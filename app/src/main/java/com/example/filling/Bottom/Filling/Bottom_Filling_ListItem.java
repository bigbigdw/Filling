package com.example.filling.Bottom.Filling;

public class Bottom_Filling_ListItem {

    String name;
    String mobile;
    int age;
    int resId;

    public Bottom_Filling_ListItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public Bottom_Filling_ListItem(String name, String mobile, int age, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
        this.resId = resId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
