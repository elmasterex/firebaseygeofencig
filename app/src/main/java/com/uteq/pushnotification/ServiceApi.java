package com.uteq.pushnotification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceApi
{
    @POST("/fcm/send")
    Call<Mensaje> create(@Body Mensaje mensaje);
}
