package com.safe.canti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Admin_PassActivity extends AppCompatActivity {


    EditText first_username , first_password , new_username , new_password ;
    Button change_pass ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pass);


        first_username = findViewById(R.id.first_username);
        first_password = findViewById(R.id.first_password);
        new_username = findViewById(R.id.new_username);
        new_password = findViewById(R.id.new_password);
        change_pass = findViewById(R.id.update_pass);



        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userEnteredUsername = first_username.getText().toString().trim();
                final String userEnteredPassword = first_password.getText().toString().trim();
                final String newusername = new_username.getText().toString().trim();
                final String newpassword = new_password.getText().toString().trim();
                //  DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Admin");
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference().child("Admin");

                root.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {


                        String passwordFromDB = dataSnapshot.child("password").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child("username").getValue(String.class);



                        if (passwordFromDB.equals(userEnteredPassword) && usernameFromDB.equals(userEnteredUsername) ) {


                            Map<String , Object> map = new HashMap<>();

                            map.put("username",new_username.getText().toString());
                            map.put("password",new_password.getText().toString());

                            root.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {

                                    Intent intent = new Intent(Admin_PassActivity.this , AdminActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(Admin_PassActivity.this , "Username and Password Updated",Toast.LENGTH_SHORT).show();

                                }
                            });

                          /*  FirebaseDatabase.getInstance().getReference()
                                    .child("Users")
                                    .child(getRef(position).getKey())
                                    .updateChildren(map)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {




                                        }

                           */



                        } else {
                            Toast.makeText(Admin_PassActivity.this,"Invalid Credentials !!",Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });



            }
        });







    }
}