package com.safe.canti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {


    TextView call_no;
    ImageView call_to;
    private  static  final int REQUEST_CALL = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        call_no= findViewById(R.id.call_no);
        call_to =findViewById(R.id.call_to);
       Intent intent = getIntent();
       String phone = intent.getStringExtra(MyAdapter.EXTRA_PHONE);
        call_no.setText(phone);



        call_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


/*
                String sa = "tel:" + phone;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(sa));

                startActivity(intent);









 */
/*

               String number = phone ;
               if(number.trim().length() > 0)
               {

                   if(ContextCompat.checkSelfPermission(CallActivity.this,

                           Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){


                       ActivityCompat.requestPermissions(CallActivity.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);


                   }else{

                       String dial = "tel:" + number;
                       startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
                   }


               }else
               {
                   Toast.makeText(CallActivity.this , "Phone number not valid", Toast.LENGTH_SHORT).show();
               }

 */

                makePhoneCall();



            }
        });





    }

    private void makePhoneCall() {

        Intent intent = getIntent();
        String phone = intent.getStringExtra(MyAdapter.EXTRA_PHONE);

        String number = phone ;
        if(number.trim().length() > 0)
        {

            if(ContextCompat.checkSelfPermission(CallActivity.this,

                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){


                ActivityCompat.requestPermissions(CallActivity.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);


            }else{

                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
            }


        }else
        {
            Toast.makeText(CallActivity.this , "Phone number not valid", Toast.LENGTH_SHORT).show();
        }







    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                makePhoneCall();

            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }

        }
    }
}