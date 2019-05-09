package example.sk.applicationten;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.eturl);
        w1=(WebView)findViewById(R.id.webView1);
        w1.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        w1.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onLoadBtnClicked(View v)
    {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                w1.loadUrl(e1.getText().toString());
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Connect To Some NetWork",Toast.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else
            {
                vibrator.vibrate(200);
            }
        }
    }
}
