package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AdminRegistration extends AppCompatActivity {

    EditText nameAdmin, locaAdmin, mobAdmin, passAdmin, repassAdmin;
    String strNameAdmin, strLocaAdmin, strMobAdmin, strPassAdmin, strRepassAdmin;
    CheckBox checkBox;
    Button adminButton;
    DataBaseHelper admin;
    long s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);

        nameAdmin = findViewById(R.id.ad_name2);
        locaAdmin = findViewById(R.id.ad_loc2);
        mobAdmin = findViewById(R.id.ad_mob2);
        passAdmin = findViewById(R.id.ad_psw2);
        repassAdmin = findViewById(R.id.ad_repsw2);

        admin = new DataBaseHelper(this);

        checkBox = findViewById(R.id.ad_checkBox2);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox = findViewById(R.id.ad_checkBox2);
                String checkBoxText = "I agree to all the <a href='https://www.sriramachandra.edu.in/medical/blood-bank/' > Terms and Conditions</a>";
                checkBox.setText(Html.fromHtml(checkBoxText));
                checkBox.setMovementMethod(LinkMovementMethod.getInstance());
                if (checkBox.isChecked()) {
                    checkBox.setVisibility(View.VISIBLE);
                } else {
                    checkBox.setVisibility(View.VISIBLE);
                }
            }
        });
        adminButton = findViewById(R.id.ad_regi_btn2);

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strNameAdmin = nameAdmin.getText().toString();
                strLocaAdmin = locaAdmin.getText().toString();
                strMobAdmin = mobAdmin.getText().toString();
                strPassAdmin = passAdmin.getText().toString();
                strRepassAdmin = repassAdmin.getText().toString();

                s = admin.save_details(strNameAdmin,strLocaAdmin,strMobAdmin,strPassAdmin,strRepassAdmin);



                if (TextUtils.isEmpty(strNameAdmin) || TextUtils.isEmpty(strLocaAdmin) || TextUtils.isEmpty(strMobAdmin) || TextUtils.isEmpty(strPassAdmin) || TextUtils.isEmpty(strRepassAdmin))

                    Toast.makeText(AdminRegistration.this, "All fields Required", Toast.LENGTH_SHORT).show();
                  if (!checkBox.isChecked()) {

                    Toast.makeText(AdminRegistration.this, "Please select terms and conditions", Toast.LENGTH_SHORT).show();
                  } else{

                        startActivity(new Intent(AdminRegistration.this, MainActivity.class));

                        Toast.makeText(AdminRegistration.this, strNameAdmin + "\n" + strLocaAdmin + "\n" + strMobAdmin + "\n" + strPassAdmin + "\n" + strRepassAdmin, Toast.LENGTH_SHORT).show();

                        Toast.makeText(AdminRegistration.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                  }
            }
        });

     }

    public void ad_back(View view) {

        startActivity(new Intent(AdminRegistration.this,MainActivity.class));
    }
}
