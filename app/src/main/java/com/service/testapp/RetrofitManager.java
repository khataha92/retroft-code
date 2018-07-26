package com.service.testapp;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private final String TAG = RetrofitManager.class.getSimpleName();

    Retrofit retrofit;

    OkHttpClient client;

    Services services;

    private static RetrofitManager instance = null;

    private RetrofitManager() {

        client = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        services = retrofit.create(Services.class);
    }

    public void getPosts(final AbstractCallback callback) {

        Call<List<Post>> getPosts = services.getPosts();

        getPosts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                callback.onResult(true, response.body());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }

    public void getPostWithId(String id, final AbstractCallback callback) {

        Call<Post> getPostWithId = services.getPostWithId(id);

        getPostWithId.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                callback.onResult(true, response.body());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                callback.onResult(false, null);
            }
        });
    }

    public void addPost(Post post) {

        Call<Post> addPost = services.addNewPost(post.getUserId(), post.getTitle(), post.getBody());

        addPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public static RetrofitManager getInstance() {

        if(instance == null) {

            instance = new RetrofitManager();
        }

        return instance;

    }
}
