package com.safe.canti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private EditText mEmail , mPass;
    private TextView mTextView;
    private Button signUpBtn,Admin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email_reg);
        mPass = findViewById(R.id.passreg);
        mTextView = findViewById(R.id.textView);
        signUpBtn = findViewById(R.id.registration_btn);
        Admin=findViewById(R.id.Admin);

      /*  FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            Intent intent = new Intent(MainActivity.this,AvailableActivity.class);
            startActivity(intent);
            this.finish();

        }

       */

        mAuth = FirebaseAuth.getInstance();

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , SigninActivity.class));
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Intent intent = new Intent(MainActivity.this , CheckActivity.class);
               startActivity(intent);

            }
        });



    }
    private void createUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(MainActivity.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this , SigninActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Already Registered !!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this , MainActivity.class));

                    }
                });
            }else{
                mPass.setError("Empty Fields Are not Allowed");
            }
        }else if(email.isEmpty()){
            mEmail.setError("Empty Fields Are not Allowed");
        }else{
            mEmail.setError("Invalid Credentials !!");
        }
    }

}