package jb.ws.conmenu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tv;

    private  static  final int REQUEST_READ_CONTACTS = 0;
    private  static  final int REQUEST_CODE_PERMISSION = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.tv1);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("select");
        menu.add("call");
        menu.add("SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String cPermission = Manifest.permission.CALL_PHONE;
        try{
            if(ActivityCompat.checkSelfPermission(this,cPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{cPermission},REQUEST_CODE_PERMISSION);
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
        if(item.getTitle().toString().equals("call"))
        {
            Toast.makeText(this,"calling...",Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9744559441"));
            try
            {
                startActivity(in);
            }
            catch (android.content.ActivityNotFoundException ex)
            {
                Toast.makeText(getApplicationContext(),"no activity found"+ex.toString(),Toast.LENGTH_SHORT).show();
            }
        }
        else if(item.getTitle().toString().equals("SMS"))
        {
            Toast.makeText(this,"Sending SMS",Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
