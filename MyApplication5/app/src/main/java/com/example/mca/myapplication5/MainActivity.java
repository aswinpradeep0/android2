package com.example.mca.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String uname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDetails();

    }
    public void getDetails()
    {




        Button btnsubmit=(Button)findViewById(R.id.buttonsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String uname2;
                EditText txtname = (EditText)findViewById(R.id.txtname);
                uname2 = txtname.getText().toString();
                Toast.makeText(getApplicationContext(),uname2,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),secondactivity.class);
                intent.putExtra(uname,uname2);
                Toast.makeText(getApplicationContext(),uname2,Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });
    }
}
