package com.example.administrator.test;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
        String nm,address,mob,mail;
        Button bt1;
    View dialogView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            bt1 = (Button)findViewById(R.id.button);
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog();
                }
            });


        }
        public void dialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = MainActivity.this.getLayoutInflater();
            dialogView = inflater.inflate(R.layout.customlayout, null);
            builder.setView(dialogView)
                    .setPositiveButton("Okay",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int d){
                            try {
                                nm = ((EditText) dialogView.findViewById(R.id.name)).getText().toString().trim();
                                address = ((EditText) dialogView.findViewById(R.id.address)).getText().toString().trim();
                                mob = ((EditText) dialogView.findViewById(R.id.mob)).getText().toString().trim();
                                mail = ((EditText) dialogView.findViewById(R.id.mail)).getText().toString().trim();
                                Cust c = new Cust(nm, address, mail, Integer.parseInt(mob),0);

                                Toast.makeText(getApplicationContext(), "Customer added successfully" , Toast.LENGTH_LONG).show();
                                dialog.cancel();
                            }catch (Exception ex){
                                Log.e("error ",ex.toString());
                                Toast.makeText(getApplicationContext(),"some invalid data inputed pls enter valid one....",Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int id){
                            dialog.cancel();
                        }
                    });
            builder.create().show();
        }
    }
