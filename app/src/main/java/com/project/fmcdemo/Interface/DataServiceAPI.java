package com.project.fmcdemo.Interface;

import com.project.fmcdemo.Models.ParentModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DataServiceAPI {

    @Headers({
            "Authorization: key=AAAA8A-s6eU:APA91bERt5r4XaOOAP1r6SChoSF4nycHe7ptK_AkYjFU-B4135hOF2FisLiaOqizRJuIC7A6PNgCM8EIcg1OosclOFr3p8IEU9FPWb9RdA27MJpbdk5HMAdC12P3w7gLcbGLphOfzBf2",
            "Content-Type: application/json"
    })

    @POST("fcm/send")
    Call<ParentModel> getAPI(@Body ParentModel example1);
}
