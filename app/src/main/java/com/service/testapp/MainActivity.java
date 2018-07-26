package com.service.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RetrofitManager.getInstance().getPosts(new AbstractCallback() {
//            @Override
//            public void onResult(boolean isSucces, Object result) {
//
//                ArrayList<Post> posts = (ArrayList<Post>) result;
//
//            }
//        });

        RetrofitManager.getInstance().getPostWithId("10", new AbstractCallback() {
            @Override
            public void onResult(boolean isSucces, Object result) {

                if(isSucces) {

                    Post post = (Post) result;

                    Log.d("status", "success");
                }

            }
        });

    }
}
