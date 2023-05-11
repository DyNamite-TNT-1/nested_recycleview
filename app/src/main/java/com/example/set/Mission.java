package com.example.set;

public class Mission {
    String id;
    String title;
    String subTitle;
    String urlImage;

    public Mission(String id, String title, String subTitle, String urlImage) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.urlImage = urlImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
