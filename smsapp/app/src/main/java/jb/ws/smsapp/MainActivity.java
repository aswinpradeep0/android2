package jb.ws.smsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    private  static  final int REQUEST_READ_CONTACTS = 0;
    private  static  final int REQUEST_CODE_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.txtno);
        et2=(EditText)findViewById(R.id.txtmsg);
        grantPermission();

    }
    public void onMessage(View V)
    {
        String phoneNumber = et1.getText().toString();
        SmsManager sms=SmsManager.getDefault();
        String msg=et2.getText().toString();
        sms.sendTextMessage(phoneNumber,null,msg,null,null);
        Toast.makeText(getApplicationContext(),"SMS SEND",Toast.LENGTH_SHORT).show();;
    }

    public void sendEmail(View V)
    {
        Log.i("send email","");
        String[] TO={"aswinpradeep0@gmail.com"};
        String[] CC={""};
        Intent emailIntent  =  new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailIntent.putExtra(Intent.EXTRA_CC,CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Android app");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Email msg goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(getApplicationContext(),"error occoured",Toast.LENGTH_SHORT).show();;

        }

    }

    public void grantPermission()
    {
        String cPermission = Manifest.permission.SEND_SMS;
        String iPermission = Manifest.permission.INTERNET;

        try{
            if(ActivityCompat.checkSelfPermission(this,cPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{cPermission},REQUEST_CODE_PERMISSION);
            }
            else if(ActivityCompat.checkSelfPermission(this,iPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{iPermission},REQUEST_CODE_PERMISSION);
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}
