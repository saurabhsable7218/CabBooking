package com.safe.canti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ShowdataActivity extends AppCompatActivity {


    private RecyclerView recyclerView2;
    private  MyAdapter adapter;
    TextView show_email;
    Button home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);


        home = findViewById(R.id.button2);
        show_email=findViewById((R.id.show_email));
        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));



         //Intent intent = getIntent();
         //String email = intent.getStringExtra(AvailableActivity.EXTRA_EMAIL2);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String email = sp.getString("email" , "");

       // home.setText(u_email);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ShowdataActivity.this , AvailableActivity.class);
                startActivity(intent);


            }
        });

/*
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users"), Model.class)
                        .build();



        adapter = new MyAdapter(options,this);
        recyclerView2.setAdapter(adapter);

 */


               FirebaseRecyclerOptions<Model> options =
                       new FirebaseRecyclerOptions.Builder<Model>()
                               .setQuery(FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("email").startAt(email).endAt(email + "\uf8ff"), Model.class)
                               .build();


               adapter = new MyAdapter(options, this);
               // adapter.startListening();
               recyclerView2.setAdapter(adapter);

           /*
               if(email.isEmpty()){

                   String email2 = intent.getStringExtra(AvailableActivity.EXTRA_EMAIL5);

                   FirebaseRecyclerOptions<Model>options =
                           new FirebaseRecyclerOptions.Builder<Model>()
                                   .setQuery(FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("email").startAt(email2).endAt(email2 + "\uf8ff"), Model.class)
                                   .build();


                   adapter = new MyAdapter(options, this);
                   // adapter.startListening();
                   recyclerView2.setAdapter(adapter);





               }

            */













    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }














}