package com.schipala_ianko_radoslav.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.schipala_ianko_radoslav.newsreader.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}