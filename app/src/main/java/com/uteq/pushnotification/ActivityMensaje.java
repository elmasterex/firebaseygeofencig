package com.uteq.pushnotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;



public class ActivityMensaje extends Activity
{
    TextView tvmensaje;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensajes);
        tvmensaje = (TextView)this.findViewById(R.id.tvmensaje);
        Bundle bundle = this.getIntent().getExtras();
        tvmensaje.setText(bundle.getString("mensaje"));



    }
}
