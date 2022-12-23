package com.project.fmcdemo.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.project.fmcdemo.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.cardToken).setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TokenActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.cardTopic).setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TopicActivity.class);
            startActivity(intent);
        });

    }
}