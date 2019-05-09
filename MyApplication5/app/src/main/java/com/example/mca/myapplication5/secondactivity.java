package com.example.mca.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mca.myapplication5.MainActivity.uname;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        displaymessage();
    }
    public void displaymessage()
    {
        Intent intent = getIntent();
        TextView txtout = (TextView)findViewById(R.id.txtout);
        String msg= intent.getStringExtra(MainActivity.uname);
        Toast.makeText(getApplicationContext(),"Hi"+msg,Toast.LENGTH_LONG).show();
        txtout.setText(msg);
    }
}
