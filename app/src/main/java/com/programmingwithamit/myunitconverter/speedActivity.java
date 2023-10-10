package com.programmingwithamit.myunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class speedActivity extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView kmh, mph, mps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_speed);
        kmh = findViewById(R.id.kmPerHour);
        mph = findViewById(R.id.meterPerHour);
        input = findViewById(R.id.input);
        changeStatusBarColor();
        unit = findViewById(R.id.unit);
        mps = findViewById(R.id.meterPerSecond);

        String[] arr = {"KM/Hour", "Mile/Hour", "Meter/Second"};

        unit.setAdapter(new ArrayAdapter(speedActivity.this, android.R.layout.simple_list_item_1, arr));


        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }


    private void update() {

        double kmPerHour = 0;
        double milesPerHour = 0;
        double meterPerSec = 0;

        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double speed = Double.parseDouble(input.getText().toString());

            switch (unit.getSelectedItem().toString()) {

                case "KM/Hour":
                    kmPerHour = speed;
                    meterPerSec = speed / 3.6;
                    milesPerHour = speed / 1.60934; // 1 km/h = 0.621371 mph
                    break;


                case "Mile/Hour":
                    milesPerHour = speed;
                    meterPerSec = speed / 2.23694;
                    kmPerHour = speed * 1.60934; // 1 mph = 1.60934 km/h
                    break;
                case "Meter/Second":
                    meterPerSec = speed;
                    kmPerHour = speed * 3.6; // 1 m/s = 3.6 km/h
                    milesPerHour = speed * 2.23694; // 1 m/s = 2.23694 mph
                    break;
            }
            kmh.setText(String.format("%.2fkm/h", kmPerHour));
            mph.setText(String.format("%.2fmp/h", milesPerHour));
            mps.setText(String.format("%.2fmp/s", meterPerSec));
        }
    }
    private void changeStatusBarColor (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#EFA332"));
        }
    }
}