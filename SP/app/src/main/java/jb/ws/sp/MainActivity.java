package jb.ws.sp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLogin(View v)
    {
        ed1=(EditText)findViewById(R.id.txt1);
        ed2=(EditText)findViewById(R.id.txt2);
        //btnlogin=(Button)findViewById(R.id.btnlogin);
        SharedPreferences sp;
        sp = getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("un",ed1.getText().toString());
        ed.putString("up",ed2.getText().toString());
        ed.commit();
        Intent in=new Intent(this,sec.class);
        startActivity(in);

    }
}
