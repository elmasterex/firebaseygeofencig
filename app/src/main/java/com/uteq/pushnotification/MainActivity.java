package com.uteq.pushnotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    Button btenviar;
    TextView tvdato;
    EditText titulo, contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btenviar = (Button) this.findViewById(R.id.btenviar);
        tvdato = (TextView) this.findViewById(R.id.tvdato);
        titulo = (EditText) this.findViewById(R.id.tvtitulo);
        contenido = (EditText) this.findViewById(R.id.tvcontenido);
        FirebaseMessaging.getInstance().subscribeToTopic("news");


        btenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                construirmensaje();
            }
        });
    }


    OkHttpClient client = new OkHttpClient.Builder().writeTimeout(10, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization",
                            "key=AAAAyXi84fA:APA91bHLTYbs5m-hcPjGmj7_tPWNgKCQYNo-4NV8p3577ZtYWn9OOo4GM3Hp_kd5bQexmswe3vpFRZWnM1I88K8Xr44JcMK9lVGJ7YmFOCH9yVpG19qj0VsG5mDe1ERj_1aaLdkTVaI3aRUWqj6tiYHcIJ4GzlwW8A")
                    .addHeader("Content-Type", "application/json")
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl("https://fcm.googleapis.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ServiceApi restClient = retrofit.create(ServiceApi.class);


    public void construirmensaje(){
        Notification notification = new Notification();
        notification.setTitle(titulo.getText().toString());
        notification.setBody(contenido.getText().toString());
        notification.getClickAction("TOP_STORY_ACTIVITY");

        Mensaje mensaje1 = new Mensaje();
        mensaje1.setTo("/topics/news");
        mensaje1.setNotification(notification);
        sent(mensaje1);
    }


    public void sent(Mensaje mensaje){
        Call<Mensaje> call = restClient.create(mensaje);
        call.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, retrofit2.Response<Mensaje> response) {
                if (response.code() == 200) {

                }
            }
            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {

            }
        });
    }



}
