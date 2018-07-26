package com.service.testapp;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    String userId;

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
