package com.example.mca.myapplication2;

import android.content.Context;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View arg0) {

                Intent intent = new Intent(context, AnotherActivity.class);

                startActivity(intent);

            }

        });

    }

}