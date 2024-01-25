package com.safe.canti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.safe.canti.SigninActivity.SHARED_PREFS;
//import static com.safe.canti.SigninActivity.TEXT;
//import static com.safe.canti.SigninActivity.TEXT2;


public class AvailableActivity extends AppCompatActivity {

    ImageView dzire,innova,baleno,honda_city,nexon,bolero;
    Button data,logout;
    public static final  String EXTRA_NAME = "com.safe.canti.extra.NAME";
    //public static  final String EXTRA_EMAIL2 = "com.safe.canti.extra.EMAIL2";
    //public static final String EXTRA_PASS2 = "com.safe.canti.extra.PASS2";
   // public static final String EXTRA_EMAIL5 = "com.safe.canti.extra.EMAIL5";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available);


        dzire=findViewById(R.id.dzire);
        innova=findViewById(R.id.innova);
        baleno =findViewById(R.id.baleno);
        honda_city=findViewById(R.id.honda_city);
        nexon = findViewById(R.id.nexon);
        bolero = findViewById(R.id.bolero);
        data = findViewById(R.id.data);
        logout = findViewById(R.id.button);




         SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
         String email = sp.getString("email" , "");
         String pass = sp.getString("pass","");




          /*

          Intent intent = getIntent();
          String  email = intent.getStringExtra(SigninActivity.EXTRA_EMAIL);
          String  pass = intent.getStringExtra(SigninActivity.EXTRA_PASS);

           */


      //  SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
     //   String email = sharedPreferences.getString(TEXT,"");


     //   String  pass = sharedPreferences.getString(TEXT2,"");









        //String pass2 = intent.getStringExtra(LastActivity.EXTRA_PASS4);
        //String email2 = intent.getStringExtra(LastActivity.EXTRA_EMAIL4);

      /*  if(email.isEmpty() && pass.isEmpty()) {

          email = intent.getStringExtra(LastActivity.EXTRA_EMAIL4);

        }

       */




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AvailableActivity.this , MainActivity.class);
                startActivity(intent);


            }
        });


        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AvailableActivity.this, ShowdataActivity.class);



                   // intent.putExtra(EXTRA_EMAIL2, email);
               // intent.putExtra(EXTRA_EMAIL5, email2);





             /*

                if(email.isEmpty())
                {
                    intent.putExtra(EXTRA_EMAIL2, email2);


                }

              */

                startActivity(intent);
                //intent.putExtra(EXTRA_EMAIL2, email2);



            }
        });





        dzire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String dzire = "Swift Dzire 18 Rs/km ";
                intent.putExtra(EXTRA_NAME, dzire);



                 //  intent.putExtra(EXTRA_EMAIL2, email);
                  // intent.putExtra(EXTRA_PASS2, pass);




/*
               if(email.isEmpty() && pass.isEmpty())
               {
                   intent.putExtra(EXTRA_EMAIL2, email2);
                   intent.putExtra(EXTRA_PASS2, pass2);

               }

 */
                startActivity(intent);


            }
        });


        innova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String innova = "Innova 20 Rs/km ";
                intent.putExtra(EXTRA_NAME, innova);



                   // intent.putExtra(EXTRA_EMAIL2, email);
                    //intent.putExtra(EXTRA_PASS2, pass);





/*
                if(email.isEmpty() && pass.isEmpty())
                {

                    intent.putExtra(EXTRA_EMAIL2, email2);
                    intent.putExtra(EXTRA_PASS2, pass2);

                }

 */
                startActivity(intent);
               // intent.putExtra(EXTRA_EMAIL2, email2);
               // intent.putExtra(EXTRA_PASS2, pass2);




            }
        });




        baleno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String baleno = "Baleno 12 Rs/km ";
                intent.putExtra(EXTRA_NAME, baleno);



                  //  intent.putExtra(EXTRA_EMAIL2, email);
                  //  intent.putExtra(EXTRA_PASS2, pass);





/*
                if(email.isEmpty() && pass.isEmpty())
                {
                    intent.putExtra(EXTRA_EMAIL2, email2);
                    intent.putExtra(EXTRA_PASS2, pass2);

                }

 */
                startActivity(intent);
               // intent.putExtra(EXTRA_EMAIL2, email2);
              //  intent.putExtra(EXTRA_PASS2, pass2);


            }
        });



        honda_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String city = "Honda City 11 Rs/km ";
                intent.putExtra(EXTRA_NAME, city);



                 //   intent.putExtra(EXTRA_EMAIL2, email);
                  //  intent.putExtra(EXTRA_PASS2, pass);



/*
                if(email.isEmpty() && pass.isEmpty())
                {
                    intent.putExtra(EXTRA_EMAIL2, email2);
                    intent.putExtra(EXTRA_PASS2, pass2);

                }

 */
                startActivity(intent);
              //  intent.putExtra(EXTRA_EMAIL2, email2);
              //  intent.putExtra(EXTRA_PASS2, pass2);


            }
        });



        nexon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String nexon = "Nexon 14 Rs/km ";
                intent.putExtra(EXTRA_NAME, nexon);



                  //  intent.putExtra(EXTRA_EMAIL2, email);
                  //  intent.putExtra(EXTRA_PASS2, pass);



/*
                if(email.isEmpty() && pass.isEmpty())
                {
                    intent.putExtra(EXTRA_EMAIL2, email2);
                    intent.putExtra(EXTRA_PASS2, pass2);

                }

 */
                startActivity(intent);
              //  intent.putExtra(EXTRA_EMAIL2, email2);
              //  intent.putExtra(EXTRA_PASS2, pass2);


            }
        });


        bolero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvailableActivity.this,UsersActivity.class);
                String bolero = "Bolero 10 Rs/km ";
                intent.putExtra(EXTRA_NAME, bolero);


                  //  intent.putExtra(EXTRA_EMAIL2, email);
                  //  intent.putExtra(EXTRA_PASS2, pass);

/*
                if(email.isEmpty() && pass.isEmpty())
                {
                    intent.putExtra(EXTRA_EMAIL2, email2);
                    intent.putExtra(EXTRA_PASS2, pass2);

                }

 */
                startActivity(intent);

             //   intent.putExtra(EXTRA_EMAIL2, email2);
             //   intent.putExtra(EXTRA_PASS2, pass2);


            }
        });






    }
}