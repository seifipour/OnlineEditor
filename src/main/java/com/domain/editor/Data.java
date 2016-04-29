package com.domain.editor;

import org.springframework.data.annotation.Id;

public class Data implements java.io.Serializable {
    @Id
    private String id;
    String title;
    String text="";
    String userName;
    String isDeleted = "false";

    public Data(String id, String title, String text,String isDeleted, String userName) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.text = text;
        this.isDeleted = isDeleted;
    }

    public Data(String userName) {
        this.title = "untitled";
        this.userName = userName;
    }

    public Data(){}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

}
