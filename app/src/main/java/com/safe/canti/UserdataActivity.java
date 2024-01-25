package com.safe.canti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class UserdataActivity extends AppCompatActivity {

    public static final String EXTRA_PHONE = "com.safe.canti.extra.PHONE";

   EditText enteruser_phone;
   Button   showdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdata);



        enteruser_phone=findViewById(R.id.enteruser_phone);
        showdata = findViewById(R.id.showdata);



     /*  showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = enteruser_phone.getText().toString();

                if (!phone.isEmpty() && phone.length() == 10) {

                    Intent intent = new Intent(UserdataActivity.this, ShowdataActivity.class);
                    intent.putExtra(EXTRA_PHONE, phone);
                    startActivity(intent);

                }
                else {

                    Toast.makeText(UserdataActivity.this,"Phone Number Must Contain 10 Numbers" ,Toast.LENGTH_SHORT).show();

                }





            }
        });

      */






    }
}