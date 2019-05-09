package jb.ws.lab8rmy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv,tv1;
    Button backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b=getIntent().getExtras();
        tv=(TextView) findViewById(R.id.tvn);
        tv1=(TextView) findViewById(R.id.tvs);
        backbutton=(Button)findViewById(R.id.backbutton);
        tv.setText("RNO: "+b.getString("Reg"));
        tv1.setText("NAME: "+b.getString("Sem"));
    }
    public void goback(View v)
    {
        Intent in;
        in=new Intent(getApplicationContext(),Main2Activity.class);

    }
}