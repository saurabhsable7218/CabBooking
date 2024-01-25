package com.safe.canti;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


/*
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;

import static android.view.Gravity.CENTER;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {






    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {




        Model model = mList.get(position);
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhone());
        holder.fromplace.setText(model.getFromplace());
        holder.toplace.setText(model.getToplace());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.phone.getContext())
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(false)//true,1100)
                        .create();



                View myview = dialogPlus.getHolderView();
                EditText name = myview.findViewById(R.id.dialog_name);
                EditText email = myview.findViewById(R.id.dialog_email);
                EditText phone = myview.findViewById(R.id.dialog_phone);
                EditText fromplace = myview.findViewById(R.id.dialog_fromplace);
                EditText toplace = myview.findViewById(R.id.dialog_toplace);
                EditText date = myview.findViewById(R.id.dialog_date);
                EditText time = myview.findViewById(R.id.dialog_time);
                Button submit =myview.findViewById(R.id.unsubmit);


                name.setText(model.getName());
                email.setText(model.getEmail());
                phone.setText(model.getPhone());
                fromplace.setText(model.getFromplace());
                toplace.setText(model.getToplace());
                date.setText(model.getDate());
                time.setText(model.getTime());



                dialogPlus.show();


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
























                        HashMap<String , String> userMap = new HashMap<>();
                        userMap.put("name",name.getText().toString());
                        userMap.put("email",email.getText().toString());
                        userMap.put("phone",phone.getText().toString());
                        userMap.put("fromplace",fromplace.getText().toString());
                        userMap.put("toplace",toplace.getText().toString());
                        userMap.put("date",date.getText().toString());
                        userMap.put("time",time.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("Users").child(getRef(position).getKey()).updateChildren(userMap)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {


                                        dialogPlus.dismiss();

                                    }
                                })


                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        dialogPlus.dismiss();



                                    }
                                });











                    }
                });







            }
        });



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, email , phone , fromplace , toplace , date , time ;
       ImageView call,edit,delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name_text);
            email=itemView.findViewById(R.id.email_text);
            phone=itemView.findViewById(R.id.phone_text);
            fromplace=itemView.findViewById(R.id.from_text);
            toplace=itemView.findViewById(R.id.to_text);
            date=itemView.findViewById(R.id.date_text);
            time=itemView.findViewById(R.id.time_text);
            call=itemView.findViewById(R.id.call);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);




        }
    }



}

 */





























































public class MyAdapter extends FirebaseRecyclerAdapter<Model, MyAdapter.PostViewHolder> {



    private Context context;
    public static final String EXTRA_PHONE = "com.example.firstmultiscreen.extra.PHONE";



    public MyAdapter(@NonNull  FirebaseRecyclerOptions<Model> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull  MyAdapter.PostViewHolder holder,final int position, @NonNull  Model model) {



        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhone());
        holder.fromplace.setText(model.getFromplace());
        holder.toplace.setText(model.getToplace());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.car.setText(model.getCar());

        holder.call_phone = model.getPhone();




        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String s = holder.call_phone;


/*
                   String s = "tel:" + holder.call_phone;
                   Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));

                  context.startActivity(intent);

 */
           Intent intent = new Intent( context,CallActivity.class);
                intent.putExtra(EXTRA_PHONE,s );
           context.startActivity(intent);














            }
        });










        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   FirebaseDatabase.getInstance().getReference()
                        .child("Users")
                        .child(getRef(position).getKey())
                        .removeValue()
                        //.setValue(null) another method for delete
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull  Task<Void> task) {




                            }
                        });

              */


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Cancel Booking");
                builder.setMessage("Are You Sure To Cancel This Booking ?!!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference()
                                .child("Users")
                                .child(getRef(position).getKey())
                                .removeValue();


                    }
                });


                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                    }
                });

                builder.show();










            }
        });





        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.phone.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1100)
                        .create();




                View myview = dialogPlus.getHolderView();
                EditText name = myview.findViewById(R.id.dialog_name);
                EditText email = myview.findViewById(R.id.dialog_email);
                EditText phone = myview.findViewById(R.id.dialog_phone);
                EditText fromplace = myview.findViewById(R.id.dialog_fromplace);
                EditText toplace = myview.findViewById(R.id.dialog_toplace);
                EditText date = myview.findViewById(R.id.dialog_date);
                EditText time = myview.findViewById(R.id.dialog_time);
                Button submit =myview.findViewById(R.id.unsubmit);


                name.setText(model.getName());
                email.setText(model.getEmail());
                phone.setText(model.getPhone());
                fromplace.setText(model.getFromplace());
                toplace.setText(model.getToplace());
                date.setText(model.getDate());
                time.setText(model.getTime());

                dialogPlus.show();


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       Map<String , String> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("fromplace",fromplace.getText().toString());
                        map.put("toplace",toplace.getText().toString());
                        map.put("date",date.getText().toString());
                        map.put("time",time.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Users").child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        dialogPlus.dismiss();

                                    }
                                })

                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull  Exception e) {

                                        dialogPlus.dismiss();

                                    }
                                });






                    }
                });

               */








                DialogPlus dialog = DialogPlus.newDialog(context)

                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1180)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();



                View myview = dialog.getHolderView();
                EditText car = myview.findViewById(R.id.dialog_car);
                EditText name = myview.findViewById(R.id.dialog_name);
                EditText email = myview.findViewById(R.id.dialog_email);
                EditText phone = myview.findViewById(R.id.dialog_phone);
                EditText fromplace = myview.findViewById(R.id.dialog_fromplace);
                EditText toplace = myview.findViewById(R.id.dialog_toplace);
                EditText date = myview.findViewById(R.id.dialog_date);
                EditText time = myview.findViewById(R.id.dialog_time);
                Button submit =myview.findViewById(R.id.unsubmit);


                car.setText(model.getCar());
                name.setText(model.getName());
                email.setText(model.getEmail());
                phone.setText(model.getPhone());
                fromplace.setText(model.getFromplace());
                toplace.setText(model.getToplace());
                date.setText(model.getDate());
                time.setText(model.getTime());

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Map<String , Object> map = new HashMap<>();
                        map.put("car",car.getText().toString());
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("fromplace",fromplace.getText().toString());
                        map.put("toplace",toplace.getText().toString());
                        map.put("date",date.getText().toString());
                        map.put("time",time.getText().toString());

                        FirebaseDatabase.getInstance().getReference()
                                .child("Users")
                                .child(getRef(position).getKey())
                                .updateChildren(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull  Task<Void> task) {


                                        dialog.dismiss();

                                    }
                                });




                    }
                });








                dialog.show();









            }
        });





    }

    @NonNull

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new PostViewHolder(view);





    }

    class PostViewHolder extends RecyclerView.ViewHolder{


        TextView name, email , phone , fromplace , toplace , date , time ,car;
        ImageView call,edit,delete;
        String call_phone;




        public PostViewHolder(@NonNull  View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name_text);
            email=itemView.findViewById(R.id.email_text);
            phone=itemView.findViewById(R.id.phone_text);
            fromplace=itemView.findViewById(R.id.from_text);
            toplace=itemView.findViewById(R.id.to_text);
            date=itemView.findViewById(R.id.date_text);
            time=itemView.findViewById(R.id.time_text);
            call=itemView.findViewById(R.id.call);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);
            car=itemView.findViewById(R.id.car_text);





        }
    }





















}
