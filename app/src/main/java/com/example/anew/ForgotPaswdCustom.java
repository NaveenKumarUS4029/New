package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ForgotPaswdCustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_paswd_custom);
    }

    public void doner_fetchback_data(View view) {
        Toast.makeText(this, "Back to Doner Login Page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ForgotPaswdCustom.this,CustomerLoginPage.class));
    }
}