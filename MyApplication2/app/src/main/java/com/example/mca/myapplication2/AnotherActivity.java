package com.example.mca.myapplication2;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

class AnotherActivity extends MainActivity {

    Button button;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_another);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);

                startActivity(intent);

            }

        });

    }

}