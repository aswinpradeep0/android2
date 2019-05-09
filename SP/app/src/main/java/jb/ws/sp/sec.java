package jb.ws.sp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sec extends AppCompatActivity {

    EditText ed1,ed2;
    Button btnlogin;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.txt1);
        ed2=(EditText)findViewById(R.id.txt2);
        //btnlogin=(Button)findViewById(R.id.btnlogin);

        sp = getSharedPreferences("SD",Context.MODE_PRIVATE);
        ed1.setText(sp.getString("un","").toString());
        ed2.setText(sp.getString("up","").toString());

    }
    public void onClose(View v)
    {
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.commit();
        finish();
    }
}
