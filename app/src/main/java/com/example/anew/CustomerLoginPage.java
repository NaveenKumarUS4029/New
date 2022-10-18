package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerLoginPage extends AppCompatActivity {

    EditText mobEd,pwdEd;
    String mobStr,pwdStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_page);

        mobEd = findViewById(R.id.cust_mob1);
        pwdEd = findViewById(R.id.cust_pwd1);
    }

    public void don_ft_pswd(View view) {
        Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CustomerLoginPage.this,ForgotPaswdCustom.class));
    }

    public void doner_login(View view) {
        mobStr = mobEd.getText().toString();
        pwdStr = pwdEd.getText().toString();


    }

    public void don_regi_here(View view) {
        Toast.makeText(this, "You Have To Register Here", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CustomerLoginPage.this,CustomerRegistration.class));
    }



}