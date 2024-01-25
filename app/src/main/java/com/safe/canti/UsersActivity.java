package com.safe.canti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class UsersActivity extends AppCompatActivity {

   // private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    TextView car_name,user_email,user_pass,enter_time, enter_date ;

    EditText enter_name,enter_email,enter_phone,enter_fromplace,enter_toplace;//enter_date;//,enter_time;
    Button submit,next,button3;
    int Hour , Minute ;


  //  FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference myRef = database.getReference("message");

 // public static final String EXTRA_EMAIL3 = "com.safe.canti.extra.EMAIL3";
  //  public static final String EXTRA_PASS3 = "com.safe.canti.extra.PASS3";

   private FirebaseDatabase db = FirebaseDatabase.getInstance();
   private DatabaseReference root = db.getReference().child("Users");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

      //  myRef.setValue("Hello, World!");

        enter_name =findViewById(R.id.enter_name);
        enter_email =findViewById(R.id.enter_email);
        enter_phone =findViewById(R.id.enter_phone);
        enter_fromplace =findViewById(R.id.enter_fromplace);
        enter_toplace =findViewById(R.id.enter_toplace);
        enter_time =findViewById(R.id.enter_time);
        car_name=findViewById(R.id.car_name);
        user_email=findViewById(R.id.user_email);
        user_pass=findViewById(R.id.user_pass);
        button3=findViewById(R.id.button3);
        enter_date = findViewById(R.id.enter_date);

        Intent intent = getIntent();
        String name = intent.getStringExtra(AvailableActivity.EXTRA_NAME);
        car_name.setText(name);


        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String  u_email = sp.getString("email" , "");
        String u_pass = sp.getString("pass","");



        user_email.setText(u_email);

        user_pass.setText(u_pass);




        submit=findViewById(R.id.submit);
        next=findViewById(R.id.next);







       /*
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog timePickerDialog = new TimePickerDialog(


                        UsersActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                Hour = hourOfDay;
                                Minute = minute ;

                                String time = Hour  +  " : "  + Minute;

                                SimpleDateFormat f24Hours =  new SimpleDateFormat(


                                        "HH:mm"


                                );

                                try {

                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(

                                            "hh:mm:aa"
                                    );

                                   //enter_time.setText(f12Hours.format(date));
                                    enter_time.setText(f12Hours.format(date));




                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }


                            }
                        },12,0,false

                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(Hour,Minute);
                timePickerDialog.show();








            }
        });

        */


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Calendar calendar = Calendar.getInstance();


                int YEAR = calendar.get(Calendar.YEAR) ;
                int MONTH = calendar.get(Calendar.MONTH);
                int DATE = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(UsersActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {

                       // String d = year + "/" + month + "/" + date ;
                        enter_date.setText(date+" / "+month+" / "+year);

                    }
                },YEAR , MONTH , DATE);

                datePickerDialog.show();


            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Calendar calendar = Calendar.getInstance();
               // int HOUR = calendar.get(Calendar.HOUR);
               // int MINUTE = calendar.get(Calendar.MINUTE);


                boolean is24HourFormat = DateFormat.is24HourFormat(UsersActivity.this);

                TimePickerDialog timePickerDialog = new TimePickerDialog(UsersActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                       // String t = hour + " : " + minute ;
                       // enter_time.setText(t);

                        Hour = hour;
                        Minute = minute ;




                        Calendar calender1 = Calendar.getInstance();
                        calender1.set(0,0,0,Hour,Minute);
                       // calender1.set(Calendar.MINUTE,minute);

                        //CharSequence charSequence = DateFormat.format("hh:mm a",calender1);
                        enter_time.setText(DateFormat.format("hh:mm a",calender1));





                    }
                },12,0,false);

                timePickerDialog.updateTime(Hour,Minute);

                timePickerDialog.show();


            }
        });








     /*   if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS))
            {

            }
            else{

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);

            }

        }

      */







       submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  myRef.setValue("Hello, World!");






                String name = enter_name.getText().toString();
             //   String email = enter_email.getText().toString();
                String email =user_email.getText().toString();
                String phone = enter_phone.getText().toString();
                String fromplace = enter_fromplace.getText().toString();
                String toplace = enter_toplace.getText().toString();
                String date = enter_date.getText().toString();
                String time = enter_time.getText().toString();
                String car = car_name.getText().toString();
                String pass = user_pass.getText().toString();








                if ( !name.isEmpty() && !phone.isEmpty() && !fromplace.isEmpty() && !toplace.isEmpty() &&
                !date.isEmpty() && !time.isEmpty() ) {

                    if (phone.length() == 10) {


                        HashMap<String, String> userMap = new HashMap<>();

                        userMap.put("name", name);
                        userMap.put("email", email);
                        userMap.put("pass", pass);
                        userMap.put("phone", phone);
                        userMap.put("fromplace", fromplace);
                        userMap.put("toplace", toplace);
                        userMap.put("date", date);
                        userMap.put("time", time);
                        userMap.put("car", car);

                        root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Toast.makeText(UsersActivity.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                                // startActivity(new Intent(UsersActivity.this , LastActivity.class));

                            }
                        });

                        // root.setValue(name);

                    } else {
                        Toast.makeText(UsersActivity.this, "Phone Number Must Contain 10 Numbers", Toast.LENGTH_SHORT).show();
                    }
                }else  {
                    Toast.makeText(UsersActivity.this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show();
                }






                if ( !name.isEmpty() &&  !phone.isEmpty() && !fromplace.isEmpty() && !toplace.isEmpty() &&
                        !date.isEmpty() && !time.isEmpty() ){


                    if (phone.length() == 10){

                        if(ContextCompat.checkSelfPermission(UsersActivity.this, Manifest.permission.SEND_SMS)
                                == PackageManager.PERMISSION_GRANTED)
                        {

                            sendMessage();


                        }else{


                            ActivityCompat.requestPermissions(UsersActivity.this,new String[]{Manifest.permission.SEND_SMS},100);


                        }
                    }else {
                        Toast.makeText(UsersActivity.this, "Phone Number Must Contain 10 Numbers", Toast.LENGTH_SHORT).show();
                    }




                }else {

                    Toast.makeText(UsersActivity.this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show();

                }










           }
        });


/*
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //sendTextMessage();





               String name = enter_name.getText().toString();
               String email = enter_email.getText().toString();
               String phone = enter_phone.getText().toString();
               String fromplace = enter_fromplace.getText().toString();
               String toplace = enter_toplace.getText().toString();
               String date = enter_date.getText().toString();
               String time = enter_time.getText().toString();










           }


       });

 */







    }

 /*   protected void sendTextMessage() {

        String sms_phone =enter_phone.getText().toString().trim();
        String sms_name = enter_name.getText().toString();
        String sms_fromplace=enter_fromplace.getText().toString();
        String sms_toplace = enter_toplace.getText().toString();
        String sms_date = enter_date.getText().toString();
        String sms_time = enter_time.getText().toString();
        String sms_message="Dear "+sms_name+" Your Cab Has Been Booked From Route "+sms_fromplace+" to "+sms_toplace+" on Date "+sms_date+" and at Time "+sms_time+" For Money Please Contact Our Driver Mobile no. :- 8180077025 .Thank You For Using Our Cab Service !! ";

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(sms_phone, null, sms_message, null, null);
        startActivity(new Intent(UsersActivity.this, LastActivity.class));

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "thanks For permitting", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(this, "required permissions !!", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

  */

    private void sendMessage() {

        String sms_phone =enter_phone.getText().toString().trim();
        String sms_name = enter_name.getText().toString();
        String sms_fromplace=enter_fromplace.getText().toString();
        String sms_toplace = enter_toplace.getText().toString();
        String sms_date = enter_date.getText().toString();
        String sms_time = enter_time.getText().toString();
        String email =user_email.getText().toString();
        String pass = user_pass.getText().toString();

        String sms="Dear "+sms_name+" Your Cab Has Been Booked From Route "+sms_fromplace+" to "+sms_toplace+" on Date "+sms_date+" and at Time "+sms_time;//+" For Money Please Contact Our Driver Mobile no.8180077025 .Thank You For Using Our Cab Service ";
        String sms_message = sms ;



           SmsManager smsManager = SmsManager.getDefault();
           smsManager.sendTextMessage(sms_phone, null, sms_message, null, null);

         Intent intent = new Intent(UsersActivity.this,LastActivity.class)  ;
         startActivity(intent);



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {

            sendMessage();


        }else{


            Toast.makeText(getApplicationContext(),"Permission Denied ", Toast.LENGTH_SHORT).show();

        }
    }

}