package com.service.testapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Services {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostWithId(@Path("id") String postId);

    @POST("posts")
    Call<Post> addNewPost(@Field("userId") String userId, @Field("title") String title, @Field("body") String body);
}
