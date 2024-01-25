package com.safe.canti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class CheckActivity extends AppCompatActivity {


    EditText username,password;
    Button login ;
    TextView change ;



 //   private FirebaseDatabase db = FirebaseDatabase.getInstance();
   // private DatabaseReference root = db.getReference().child("Admin_Pass");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check2);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.admin_btn);
        change = findViewById(R.id.change_admin_pass);


        String name = "admin";
        String pass =  "admin123";

       // HashMap<String, String> userMap = new HashMap<>();

        //userMap.put("username", name);
       // userMap.put("password", pass);

        //root.push().setValue(userMap);





       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               final String userEnteredUsername = username.getText().toString().trim();
               final String userEnteredPassword = password.getText().toString().trim();
               //  DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Admin");
               FirebaseDatabase db = FirebaseDatabase.getInstance();
               DatabaseReference root = db.getReference().child("Admin");
             //  Query checkUser = root.orderByChild("username").equalTo(userEnteredUsername);

               root.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {


                       String passwordFromDB = dataSnapshot.child("password").getValue(String.class);
                       String usernameFromDB = dataSnapshot.child("username").getValue(String.class);



                       if (passwordFromDB.equals(userEnteredPassword) &&usernameFromDB.equals(userEnteredUsername) ) {



                         Intent intent = new Intent(CheckActivity.this , AdminActivity.class);
                         startActivity(intent);
                           Toast.makeText(CheckActivity.this, "Access Granted !!" ,Toast.LENGTH_SHORT).show();


                       } else {
                           Toast.makeText(CheckActivity.this, "Invalid Credentials !!" ,Toast.LENGTH_SHORT).show();
                       }



                   }

                   @Override
                   public void onCancelled(@NonNull @NotNull DatabaseError error) {





                   }
               });




           }
       });




       change.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(CheckActivity.this , Admin_PassActivity.class);
               startActivity(intent);


           }
       });
















    }




}