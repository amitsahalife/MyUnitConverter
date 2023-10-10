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

public class temActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView celciusTextView;
    TextView fahrenheitTextView;
    TextView kelvinTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem);
        changeStatusBarColor();
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        celciusTextView = findViewById(R.id.celcius);
        fahrenheitTextView = findViewById(R.id.farenhite);
        kelvinTextView = findViewById(R.id.kelvin);

        String[] arr = {"C°", "F°", "K°"};

        unit.setAdapter(new ArrayAdapter(temActivity.this, android.R.layout.simple_list_item_1, arr));

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

        double celsius = 0;
        double fahrenheit = 0;
        double kelvin = 0;
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double temperature = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {

                case "C°":

                    celsius = temperature;
                    fahrenheit = (temperature * 9 / 5) + 32;
                    kelvin = temperature + 273.15;
                    break;

                case "F°":
                    fahrenheit = temperature;
                    celsius = (temperature - 32) * 5 / 9;
                    kelvin = temperature + 273.15;
                    break;

                case "K°":
                    kelvin = temperature;
                    celsius = temperature - 273.15;
                    fahrenheit = (celsius * 9 / 5) + 32;
                    break;

            }

            celciusTextView.setText(String.format("%.2f°C", celsius));
            fahrenheitTextView.setText(String.format("%.2f°F",fahrenheit ));
            kelvinTextView.setText(String.format("%.2f°K", kelvin));
        }
    }
    private void changeStatusBarColor (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2DB8A2"));

        }
    }
}