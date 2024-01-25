package com.safe.canti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SigninActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL = "com.safe.canti.extra.EMAIL";
    public static final String EXTRA_PASS = "com.safe.canti.extra.PASS";
    SharedPreferences sp ;
   public String shared_email , shared_pass ;

    private EditText mEmail , mPass;
    private TextView mTextView, forgot;
    private Button signInBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEmail = findViewById(R.id.email_signin);
        mPass = findViewById(R.id.passsignin);
        signInBtn = findViewById(R.id.singin_btn);
        mTextView = findViewById(R.id.textView2);
        forgot = findViewById(R.id.forgot);


       sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


    /*    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            Intent intent = new Intent(SigninActivity.this,AvailableActivity.class);
            startActivity(intent);
            this.finish();

        }

     */






        mAuth = FirebaseAuth.getInstance();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SigninActivity.this , MainActivity.class));
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });




        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SigninActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SigninActivity.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();

            }
        });







    }
    private void loginUser(){

       String email = mEmail.getText().toString();
       String pass = mPass.getText().toString();

     /*   SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
        String email2 = sharedPreferences.getString(TEXT,"");
        String  pass2 = sharedPreferences.getString(TEXT2,"");

      */

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email , pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(SigninActivity.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SigninActivity.this , AvailableActivity.class);
                                saveData();
                             //  intent.putExtra(EXTRA_EMAIL, email2);
                               //intent.putExtra(EXTRA_PASS, pass2);
                                startActivity(intent);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SigninActivity.this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                mPass.setError("Empty Fields Are not Allowed");
            }
        }else if(email.isEmpty()){
            mEmail.setError("Empty Fields Are not Allowed");
        }else{
            mEmail.setError("Pleas Enter Correct Email");
        }
    }



    private void saveData() {


       shared_email = mEmail.getText().toString();
       shared_pass = mPass.getText().toString();

       SharedPreferences.Editor editor = sp.edit();
       editor.putString("email" , shared_email);
       editor.putString("pass",shared_pass);
       editor.commit();





    }



}