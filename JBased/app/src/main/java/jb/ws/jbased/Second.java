package jb.ws.jbased;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    Button bh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bh=(Button)findViewById(R.id.bhybrid);
        bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hybrid pressed",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onBshow(View v) {
        Toast.makeText(getApplicationContext(),"button is pressed",Toast.LENGTH_SHORT).show();

    }
}
