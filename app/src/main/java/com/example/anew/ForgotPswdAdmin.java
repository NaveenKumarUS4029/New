package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ForgotPswdAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pswd_admin);
    }

    public void admin_fetchback_data(View view) {
        Toast.makeText(this, "Back to Admin Login Page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ForgotPswdAdmin.this,MainActivity.class));
    }
}