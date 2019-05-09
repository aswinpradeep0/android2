package jb.ws.speakapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button b1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

    }

    public void onTextToSpeech(View v) {
        ed1 = (EditText) findViewById(R.id.editText1);
        String str = ed1.getText().toString();
        t1.speak(str, TextToSpeech.QUEUE_FLUSH, null);

    }
}