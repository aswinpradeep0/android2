package jb.ws.lab6;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eno,ename,esal;
    SharedPreferences sp;
    String oldr,newr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eno=(EditText)findViewById(R.id.eno);
        ename=(EditText)findViewById(R.id.ename);
        esal=(EditText)findViewById(R.id.esal);
    }
    public void onAddBtnClicked(View v)
    {
        sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        if(eno.getText().toString().equals("")||esal.getText().toString().equals("")||ename.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else if(!sp.getString("eno" + eno.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
        }
        else {
            ed.putString("eno" + eno.getText().toString(), eno.getText().toString());
            ed.putString("ename" + eno.getText().toString(), ename.getText().toString());
            ed.putString("esal" + eno.getText().toString(), esal.getText().toString());
            ed.commit();
            Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
            eno.setText("");
            ename.setText("");
            esal.setText("");
        }
    }
    public void onReadBtnClicked(View v)
    {
        if(eno.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Roll Number",Toast.LENGTH_SHORT).show();
            eno.setText("");
            ename.setText("");
            esal.setText("");
        }
        else {
            oldr=eno.getText().toString();
            sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
            if(sp.getString("ename" + eno.getText().toString(), "").toString().equals(""))
            {
                Toast.makeText(getApplicationContext(),"No Employee",Toast.LENGTH_SHORT).show();
            }
            else {
                ename.setText(sp.getString("ename" + eno.getText().toString(), "").toString());
                esal.setText(sp.getString("esal" + eno.getText().toString(), "").toString());
            }
        }
    }
    public void onUpdateBtnClicked(View v)
    {
        newr=eno.getText().toString();
        sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        if(eno.getText().toString().equals("")||esal.getText().toString().equals("")||ename.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else if(!oldr.equals(newr) && !sp.getString("eno" + eno.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
        }
        else {
            ed.putString("eno" + eno.getText().toString(), eno.getText().toString());
            ed.putString("ename" + eno.getText().toString(), ename.getText().toString());
            ed.putString("esal" + eno.getText().toString(), esal.getText().toString());
            ed.commit();
            ed.apply();
            Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
            eno.setText("");
            ename.setText("");
            esal.setText("");
        }
    }
    public void onDeleteBtnClicked(View v)
    {
        if(eno.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Employee Number",Toast.LENGTH_SHORT).show();
        }
        else if(sp.getString("eno" + eno.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Employee Not Found",Toast.LENGTH_SHORT).show();
        }
        else {
            sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.remove("eno" + eno.getText().toString());
            ed.remove("ename" + eno.getText().toString());
            ed.remove("esal" + eno.getText().toString());
            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
            ed.commit();
            ed.apply();
            eno.setText("");
            ename.setText("");
            esal.setText("");
        }
    }
}