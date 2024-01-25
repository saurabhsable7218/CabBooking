package com.safe.canti;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.safe.canti.R;
import com.safe.canti.SigninActivity;

public class LastActivity extends AppCompatActivity {




  //  public static final String EXTRA_EMAIL4 = "com.safe.canti.extra.EMAIL4";
   // public static final String EXTRA_PASS4 = "com.safe.canti.extra.PASS4";


    TextView last_email , last_pass ;
    Button signOutBtn;
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);





        signOutBtn=findViewById(R.id.signOutBtn);
        last_email = findViewById(R.id.last_email);
        last_pass = findViewById(R.id.last_pass);




        //mAuth=FirebaseAuth.getInstance();

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  mAuth.signOut();
               Intent intent = new Intent(LastActivity.this,AvailableActivity.class);
             //   intent.putExtra(EXTRA_EMAIL4, email);
              //  intent.putExtra(EXTRA_PASS4, pass);
                startActivity(intent);


               // finish();


            }
        });
    }
}