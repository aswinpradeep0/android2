package com.example.mca.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changepage();
        }
        public void changepage()
        {
            final Context currentpage = this;
            Button btn = (Button)findViewById(R.id.button1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(currentpage,Main2Activity.class);
                    startActivity(i);
                }
            });
        }
}
