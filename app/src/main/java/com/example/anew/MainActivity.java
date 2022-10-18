package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mobEd,pwdEd;
    String mobStr,pwdStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobEd = findViewById(R.id.admin_mob1);
        pwdEd = findViewById(R.id.admin_pwd1);

    }

    public void admin_login(View view) {
        mobStr = mobEd.getText().toString();
        pwdStr = pwdEd.getText().toString();


    }

    public void admin_ft_pswd(View view) {
        Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,ForgotPswdAdmin.class));
    }

    public void admin_donerlog_in(View view) {
        Toast.makeText(this, "welcome to login page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,CustomerLoginPage.class));
    }

    public void admin_regi_here(View view) {
        Toast.makeText(this, "welcome to admin page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,AdminRegistration.class));
    }



}