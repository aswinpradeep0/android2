package com.example.mca.lab2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button button2;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(getApplicationContext(),"onCreate of ACTIVITY 2",Toast.LENGTH_LONG).show();
        builder=new AlertDialog.Builder(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
            }
        });
    }
        @Override
        protected void onStart() {
            super.onStart();
            Log.d("lifecycle","onStart invoked");
            Toast.makeText(getApplicationContext(),"onStart of ACTIVITY 2",Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onResume() {
            super.onResume();
            builder.setMessage("SECONE ACTIVITY STARTED")
                    .setCancelable(true);
            AlertDialog alert=builder.create();
            alert.setTitle("LAB 2");
            alert.show();

            Log.d("lifecycle","onResume invoked");
            Toast.makeText(getApplicationContext(),"onResume of ACTIVITY 2",Toast.LENGTH_LONG).show();

        }
        @Override
        protected void onPause() {
            super.onPause();
            Log.d("lifecycle","onPause invoked");
            Toast.makeText(getApplicationContext(),"onPause of ACTIVITY 2",Toast.LENGTH_LONG).show();

        }
        @Override
        protected void onStop() {
            super.onStop();
            Log.d("lifecycle","onStop invoked");
            Toast.makeText(getApplicationContext(),"onStop of ACTIVITY 2",Toast.LENGTH_LONG).show();

        }
        @Override
        protected void onRestart() {
            super.onRestart();
            Log.d("lifecycle","onRestart invoked");
            Toast.makeText(getApplicationContext(),"onRestart of ACTIVITY 2",Toast.LENGTH_LONG).show();

        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d("lifecycle","onDestroy invoked of ACTIVITY 2");
            Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_LONG).show();
    }
}
