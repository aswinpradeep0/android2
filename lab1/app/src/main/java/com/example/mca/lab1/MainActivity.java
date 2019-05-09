package com.example.mca.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinnerDropDownView;
    String[] spinnerValueHoldValue = {"BCA", "BBA", "BA", "B.SC"};

    Button buttonsignin;
    EditText txtuname;
    EditText txtpassword;
    RadioGroup radiogroup;
    RadioButton radiobutton;


    public static final String v1  ="";
    public static final String v2  ="";
    public static final String v3  ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDropDownView =(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, spinnerValueHoldValue);
        spinnerDropDownView.setAdapter(adapter);

        spinnerDropDownView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                Toast.makeText(MainActivity.this, spinnerDropDownView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        radiogroup=findViewById(R.id.radiogroup);
        buttonsignin=(Button)findViewById(R.id.buttonsignin);
        buttonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sid=radiogroup.getCheckedRadioButtonId();
                radiobutton=(RadioButton)findViewById(sid);

                txtuname = (EditText)findViewById(R.id.txtuname);
                txtpassword = (EditText)findViewById(R.id.txtpassword);

                if(txtuname.getText().toString().equals("")||txtpassword.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields empty",Toast.LENGTH_LONG).show();;
                }
                else {
                    Toast.makeText(getApplicationContext(),txtuname.getText().toString()+txtpassword.getText().toString(),Toast.LENGTH_LONG).show();;
                    Intent intent1 = new Intent(getApplicationContext(), secondactivity.class);
                    intent1.putExtra("v1", txtuname.getText().toString());
                    intent1.putExtra("v2", radiobutton.getText().toString());
                    intent1.putExtra("v3",spinnerDropDownView.getSelectedItem().toString());

                    startActivity(intent1);
                }

            }
        });
    }
}
