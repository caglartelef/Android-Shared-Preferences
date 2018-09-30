package com.caglartelef.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref.context = getApplicationContext();
        SharedPref.getMyInstance().setUsername("caglartelef.com");
        SharedPref.getMyInstance().setPassword("github.com/caglartelef");

        Log.d("SharedPref", SharedPref.getMyInstance().getUsername());
        Log.d("SharedPref", SharedPref.getMyInstance().getPassword());

    }
}
