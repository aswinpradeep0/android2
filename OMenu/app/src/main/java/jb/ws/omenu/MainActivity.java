package jb.ws.omenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().toString().equals("Exit"))
        {
            finish();
            return true;
        }
        else if(item.getTitle().toString().equals("NEW"))
        {
            Toast.makeText(this,"New menu clicked",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.about)
        {
            Toast.makeText(this,"about menu clicked",Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}
