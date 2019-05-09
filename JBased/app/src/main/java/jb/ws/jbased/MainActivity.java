package jb.ws.jbased;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button bPress,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bPress = new Button(this);
        b2= new Button(this);
        b3= new Button(this);


        bPress.setText(" press me");
        b2.setText("click me");
        b3.setText("third button");

        LinearLayout lWindow = new LinearLayout(this);
        lWindow.setOrientation(LinearLayout.VERTICAL);
        lWindow.addView(bPress);
        lWindow.addView(b2);
        lWindow.addView(b3);


        b2.setOnClickListener(this);
        b3.setOnClickListener(this);


        bPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"welcome to java programming",Toast.LENGTH_SHORT).show();
            }
        });

        setContentView(lWindow);


    }

    @Override
    public void onClick(View v) {

        Toast.makeText(getApplicationContext(),"click me pressed",Toast.LENGTH_SHORT).show();

    }
}
