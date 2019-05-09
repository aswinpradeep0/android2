package jb.ws.lab5;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements AsyncListener ,AsyncImageListener  {

    private ImageView imageView;
    private ProgressBar progressBar;
    private final String IMAGE_URL = "https://www.w3schools.com/bootstrap/paris.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        Button buttonImage = findViewById(R.id.buttonImage);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new AsyncImageDownload(this).execute(IMAGE_URL);

            }
        });



    }

    @Override
    public void getBitmap(Bitmap bitmap) {
        progressBar.setVisibility(View.GONE);
        imageView.setImageBitmap(bitmap);
    }


}


