package com.example.bohdan.new_app_tanks;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class ActivityTWO extends AppCompatActivity {
    MiddleTank tank;
   // MiddleTank tank2;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tank = (MiddleTank) getIntent().getSerializableExtra("item");

        Resources resources = getResources();
        int gap = resources.getIdentifier(tank.name,"drawable","com.example.bohdan.new_app_tanks");

        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        imageView.setImageResource(gap);
    }
}
