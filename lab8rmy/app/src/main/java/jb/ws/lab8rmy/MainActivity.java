package jb.ws.lab8rmy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        e1=(EditText) findViewById( R.id.etr );
        e2=(EditText) findViewById( R.id.ets );
        b=(Button) findViewById(R.id.bshow);
    }
    public void callme(View v)
    {

        if(e1.getText().toString().equals("") && e2.getText().toString().equals(""))
        {
            final AlertDialog.Builder al = new AlertDialog.Builder(this);
            al.setTitle("RESULT");
            al.setMessage( "Enter rno a" );
            al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    e1.setHint("Enter reg no");
                    e2.setHint("Enter semester");
                }
            });
            al.show();
        }
        else
        {
            final AlertDialog.Builder al = new AlertDialog.Builder(this);
            al.setMessage( "Want to continue with Rno : "+e1.getText().toString() );
            al.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent in;
                    in=new Intent(getApplicationContext(),Main2Activity.class);
                    Bundle b=new Bundle();
                    b.putString("Reg",e1.getText().toString());
                    b.putString("Sem",e2.getText().toString());
                    in.putExtras(b);
                    startActivity(in);
                }
            });
            al.setCancelable(true);
            al.show();
            al.show();
        }
    }
}