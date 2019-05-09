package jb.ws.fileapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private  static  final int REQUEST_READ_CONTACTS = 0;
    private  static  final int REQUEST_CODE_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grantPermission();

    }

    public void onSaveClick(View V)
    {
        try
        {
            EditText e1=(EditText)findViewById(R.id.tctFn);
            EditText e2=(EditText)findViewById(R.id.txtCon);
            FileOutputStream fout;
            fout=openFileOutput(e1.getText().toString(),0);
            OutputStreamWriter osw = new OutputStreamWriter(fout);
            osw.write(e2.getText().toString());
            osw.flush();
            osw.close();
            Toast.makeText(this,"SAVED",Toast.LENGTH_SHORT).show();


        }
        catch (Exception f)
        {
            f.printStackTrace();
        }

    }

    public void onOpenClick(View V)
    {
        try
        {
            EditText e1=(EditText)findViewById(R.id.tctFn);
            EditText e2=(EditText)findViewById(R.id.txtCon);
            FileInputStream fin;
           fin=openFileInput(e1.getText().toString());
            InputStreamReader isw = new InputStreamReader(fin);
            char []b = new char[fin.available()];
            int n = isw.read(b,0,fin.available());
            String str = new String(b,0,n);
            e2.setText(str);
            isw.close();
            Toast.makeText(this,"OPENED",Toast.LENGTH_SHORT).show();



        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    }

    public void onClickDownload(View v)
    {
        EditText e1=(EditText)findViewById(R.id.tctFn);
        String qs = e1.getText().toString();
        try
        {
            URL url= new URL(qs);
            URLConnection connection=url.openConnection();
                connection.connect();
                int lengthOfFile = connection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream());

            OutputStream output = new FileOutputStream("/storage/emulated/0/documents/test.pdf");
                    byte data[]=new  byte[1024];
            int count;
            long total = 0;

            while((count = input.read(data))!=1){
                total += count;
                output.write(data,0,count);
            }
            output.flush();
            output.close();
            input.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void grantPermission()
    {
        String cPermission = Manifest.permission.SEND_SMS;
        String iPermission = Manifest.permission.INTERNET;
        String rPermission = Manifest.permission.READ_EXTERNAL_STORAGE;
        String wPermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        String nPermission = Manifest.permission.ACCESS_NETWORK_STATE;





        try{
            if(ActivityCompat.checkSelfPermission(this,cPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{cPermission},REQUEST_CODE_PERMISSION);
            }
            else if(ActivityCompat.checkSelfPermission(this,iPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{iPermission},REQUEST_CODE_PERMISSION);
            }
            else if(ActivityCompat.checkSelfPermission(this,rPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{rPermission},REQUEST_CODE_PERMISSION);
            }
            else if(ActivityCompat.checkSelfPermission(this,wPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{wPermission},REQUEST_CODE_PERMISSION);
            }
            else if(ActivityCompat.checkSelfPermission(this,nPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{nPermission},REQUEST_CODE_PERMISSION);
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


}
