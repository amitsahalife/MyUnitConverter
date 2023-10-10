package com.programmingwithamit.myunitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
CardView distance,temp,speed, weight,internet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distance = findViewById(R.id.distanceCard);
        temp = findViewById(R.id.tempCard);
        weight = findViewById(R.id.WeightCard);
        speed = findViewById(R.id.speedCard);
        internet = findViewById(R.id.internetCard);
changeStatusBarColor();

        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,distanceActivity.class);
                startActivity(intent);
            }
        });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,weightActivity.class);
                startActivity(intent);

            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,temActivity.class);
                startActivity(intent);
            }
        });
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,speedActivity.class);
                startActivity(intent);
            }
        });
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,storageUnit.class);
                startActivity(intent);
            }
        });


    }

    private void changeStatusBarColor (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#3A3838"));
        }
    }
}