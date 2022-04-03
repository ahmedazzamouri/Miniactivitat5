package com.example.miniactivitat5_azzamouriallal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView top;
    private TextView bot;
    ConnectivityManager connectivityManager;
    NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top = findViewById(R.id.toptext);
        bot = findViewById(R.id.bottext);

        this.connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        this.networkManager = new NetworkManager(this);
        this.networkManager.execute(this.connectivityManager, top, bot);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.networkManager.cancel(true);
    }
}