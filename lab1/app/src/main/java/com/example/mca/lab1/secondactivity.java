package com.example.mca.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {

    TextView txtoutput;
    TextView txtgender;
    TextView txtdrop;

    String s1;
    String s2;
    String s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        Bundle intent2 =getIntent().getExtras();
        s1=intent2.get("v1").toString();
        s2=intent2.get("v2").toString();
        s3=intent2.get("v3").toString();


        txtoutput=(TextView)findViewById(R.id.txtoutput);
        txtoutput.setText("Username :  "+s1);

        txtgender=(TextView)findViewById(R.id.txtgender);
        txtgender.setText("Gender :  "+s2);

        txtdrop=(TextView)findViewById(R.id.txtdrop);
        txtdrop.setText("COURSE :  "+s3);

        Button buttonback = (Button)findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
