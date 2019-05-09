package com.example.mca.workshop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext1=(EditText)findViewById(R.id.editText1);
        EditText edittext2=(EditText)findViewById(R.id.editText2);
        Button button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        })

    }
}
