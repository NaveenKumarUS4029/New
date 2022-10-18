package com.example.anew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomerRegistration extends AppCompatActivity {

    EditText nameEd, passEd, repassEd, mobEd, dateEd, timeEd,locEd;
    String nameStr, passStr, repassStr, mobStr,dateStr, timeStr, bldgrpStr, locStr;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3;
    Button dateBtn, timeBtn, submitBtn;
    Spinner bldSpinner;
    CheckBox checkBox;
    ArrayList arrayList ;
    ArrayAdapter arrayAdapter;
    DonerDBHelper doner;
    long cust;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        nameEd = findViewById(R.id.cust_name2);
        passEd = findViewById(R.id.cust_psw2);
        repassEd = findViewById(R.id.cust_repsw2);
        mobEd = findViewById(R.id.cust_mob2);
        locEd = findViewById(R.id.cust_loc2);

        timeEd = findViewById(R.id.cust_time2);
        dateEd = findViewById(R.id.cust_date_donate2);

        radioGroup = findViewById(R.id.radio_grp);
        radioButton1 = findViewById(R.id.r1);
        radioButton2 = findViewById(R.id.r2);
        radioButton3 = findViewById(R.id.r3);

        bldSpinner = findViewById(R.id.blood_spinner2);

        arrayList = new ArrayList();

        arrayList.add("Select Blood Type");
        arrayList.add("A+");
        arrayList.add("A-");
        arrayList.add("B+");
        arrayList.add("B-");
        arrayList.add("O+");
        arrayList.add("O-");
        arrayList.add("AB+");
        arrayList.add("AB-");

        arrayAdapter = new ArrayAdapter(CustomerRegistration.this, android.R.layout.simple_list_item_1, arrayList);
        bldSpinner.setAdapter(arrayAdapter);

        bldSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

//                Toast.makeText(CustomerRegistration.this, "Thanks "+ arrayListVar.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dateBtn = findViewById(R.id.cust_date_donate_btn2);

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CustomerRegistration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {

                        dateEd.setText(mDay + "-" + (mMonth + 1) + "-" + mYear);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        timeBtn = findViewById(R.id.cust_time_btn2);

        Calendar cTime = Calendar.getInstance();
        int hour = cTime.get(Calendar.HOUR_OF_DAY);
        int minute = cTime.get(Calendar.MINUTE);

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog mTimePicker = new TimePickerDialog(CustomerRegistration.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeEd.setText(selectedHour + ":" + selectedMinute );
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        checkBox = findViewById(R.id.cust_checkBox2);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        submitBtn = findViewById(R.id.cust_sub_btn2);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nameStr = nameEd.getText().toString();
                passStr = passEd.getText().toString();
                repassStr = repassEd.getText().toString();
                mobStr = mobEd.getText().toString();
                dateStr = dateEd.getText().toString();
                timeStr = timeEd.getText().toString();
                locStr = locEd.getText().toString();


             cust = doner.save_details(nameStr, passStr, repassStr, mobStr,dateStr, timeStr, bldgrpStr, locStr);

                if (TextUtils.isEmpty(nameStr) || TextUtils.isEmpty(passStr) || TextUtils.isEmpty(repassStr) || TextUtils.isEmpty(mobStr) || TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(timeStr) || TextUtils.isEmpty(locStr))
                    Toast.makeText(CustomerRegistration.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    if (!passStr.equals(repassStr)) {

                        Toast.makeText(CustomerRegistration.this, "Password must be same", Toast.LENGTH_SHORT).show();

                    } else if (!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked()) {

                        Toast.makeText(CustomerRegistration.this, "Please select your gender", Toast.LENGTH_SHORT).show();

                    } else if (!checkBox.isChecked()) {

                        Toast.makeText(CustomerRegistration.this, "Please select terms and conditions", Toast.LENGTH_SHORT).show();

                    } else {

                        AlertDialog.Builder alert = new AlertDialog.Builder(CustomerRegistration.this);
                        alert.setTitle("Alert!!");
                        alert.setMessage("Are you sure below the details are correct ?");
                        alert.setIcon(android.R.drawable.ic_media_ff);
                        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(CustomerRegistration.this, nameStr + "\n" + passStr + "\n" + repassStr + "\n" + mobStr + "\n" + dateStr + "\n" + timeStr + "\n" + locStr, Toast.LENGTH_LONG).show();

                                Intent cust_regi_intent = new Intent(CustomerRegistration.this, CustomerLoginPage.class);
                                startActivity(cust_regi_intent);

                                Toast.makeText(CustomerRegistration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert.setNegativeButton("NO", null);
                        alert.setNeutralButton("Cancel", null);
                        alert.show();
                }
              }
            }
        });
    }

    public void cust_back (View view){
                        startActivity(new Intent(CustomerRegistration.this, CustomerLoginPage.class));
                    }
                }

