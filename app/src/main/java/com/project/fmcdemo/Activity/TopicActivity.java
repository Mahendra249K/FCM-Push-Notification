package com.project.fmcdemo.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.fmcdemo.Interface.DataServiceAPI;
import com.project.fmcdemo.Models.ChildModel;
import com.project.fmcdemo.Models.ParentModel;
import com.project.fmcdemo.R;

import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopicActivity extends AppCompatActivity {

    TextView sendButton, topic;
    EditText title, body;
    String strTitle, strBody, strTo;
    ParentModel example1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        sendButton = findViewById(R.id.sendButton);
        title = findViewById(R.id.title);
        topic = findViewById(R.id.topic);
        body = findViewById(R.id.body);

        /* This method is use to scribe a topic */
        FirebaseMessaging.getInstance().subscribeToTopic("sub").addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.e("FCM_TOPIC", "Subscribed Successful..");
            } else {
                Log.e("FCM_TOPIC", "Subscribed Fail..");
            }
        });
        sendButton.setOnClickListener(v -> {
            if (title.getText().toString().trim().isEmpty()) {
                Toast.makeText(TopicActivity.this, "Please enter title..", Toast.LENGTH_SHORT).show();
            } else if (body.getText().toString().trim().isEmpty()) {
                Toast.makeText(TopicActivity.this, "Please enter Description..", Toast.LENGTH_SHORT).show();
            } else if (topic.getText().toString().trim().isEmpty()) {
                Toast.makeText(TopicActivity.this, "Please enter User Token empty", Toast.LENGTH_SHORT).show();
            } else {
                strTitle = title.getText().toString();
                strBody = body.getText().toString();
                strTo = topic.getText().toString();

                getData(example1 = new ParentModel(strTo, new ChildModel(strTitle, strBody)));

            }

        });

    }

    public void getData(ParentModel example1) {


        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://fcm.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create(gson));

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1));
        Retrofit retrofit = builder.client(httpClient.build()).build();

        DataServiceAPI service = retrofit.create(DataServiceAPI.class);
        Call<ParentModel> call = service.getAPI(example1);

        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(@NonNull Call<ParentModel> call, @NonNull Response<ParentModel> response) {
                Toast.makeText(TopicActivity.this, "send", Toast.LENGTH_SHORT).show();
                Log.i("ActivityData", String.valueOf(response.body()));

                MyReceiver myReceiver = new MyReceiver();
                registerReceiver(myReceiver, new IntentFilter("MyOwnAction"));
                sendBroadcast(new Intent("MyOwnAction"));
            }

            @Override
            public void onFailure(@NonNull Call<ParentModel> call, @NonNull Throwable t) {
                Toast.makeText(TopicActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            sendButton.setText("Update Button");
            title.setText("");
            body.setText("");

        }
    }
}