package example.sk.applicationeleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    EditText eturl;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eturl=(EditText)findViewById(R.id.eturl);
        i=(ImageView)findViewById(R.id.imageView1);
        Picasso.with(this).load(R.drawable.img).into(i);
    }
    public void onLoadBtnClicked(View v)
    {
        if(eturl.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter URL",Toast.LENGTH_SHORT).show();
        }
        else {
            Picasso.with(this).load(eturl.getText().toString()).placeholder(R.drawable.img).error(R.drawable.error).into(i);
        }
    }
    public void onRotateClicked1(View v)
    {
        Picasso.with(this).load(eturl.getText().toString()).rotate(90f).into(i);
    }
    public void onRotateClicked2(View v)
    {
        Picasso.with(this).load(eturl.getText().toString()).rotate(180f).into(i);
    }
    public void onRotateClicked3(View v)
    {
        Picasso.with(this).load(eturl.getText().toString()).rotate(270f).into(i);
    }
    public void onRotateClicked4(View v)
    {
        Picasso.with(this).load(eturl.getText().toString()).rotate(360f).into(i);
    }
}
