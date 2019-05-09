package jb.ws.lab9;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ConnectionReceiver receiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        receiver = new ConnectionReceiver();
        intentFilter = new IntentFilter("com.journaldev.broadcastreceiver.SOME_ACTION");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

    @OnClick(R.id.button)
    void someMethod() {

        Intent intent = new Intent("com.journaldev.broadcastreceiver.SOME_ACTION");
        sendBroadcast(intent);
    }
}
