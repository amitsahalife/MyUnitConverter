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

public class weightActivity extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView kg, gram, mg, pound, oz, ton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        changeStatusBarColor();
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        kg = findViewById(R.id.kg);
        gram = findViewById(R.id.gram);
        mg = findViewById(R.id.mg);
        pound = findViewById(R.id.pounds);
        oz = findViewById(R.id.ounce);
        ton = findViewById(R.id.ton);
        String[] arr = {"kg", "g", "mg", "lb", "oz", "ton"};
        unit.setAdapter(new ArrayAdapter(weightActivity.this, android.R.layout.simple_list_item_1, arr));

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
        double grams = 0;
        double milligrams = 0;
        double pounds = 0;
        double kilograms = 0;
        double ounces = 0;
        double metricTons = 0;
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double weight = Double.parseDouble(input.getText().toString());

            switch (unit.getSelectedItem().toString()) {

                case "kg":
                    kilograms = weight;
                    grams = kilograms * 1000;
                    milligrams = grams * 1000;
                    pounds = grams / 453.592;
                    break;
                case "g":
                    grams = weight;
                    milligrams = grams * 1000;
                    pounds = grams / 453.592;
                    kilograms = grams / 1000;
                    break;
                case "mg":
                    milligrams = weight;
                    grams = milligrams / 1000;
                    pounds = grams / 453.592;
                    kilograms = grams / 1000;
                    break;
                case "mm":
                    milligrams = weight;
                    grams = milligrams / 1000;
                    pounds = grams / 453.592;
                    kilograms = grams / 1000;
                    break;
                case "lb":
                    pounds = weight;
                    grams = pounds * 453.592;
                    milligrams = grams * 1000;
                    kilograms = grams / 1000;
                    break;

                case "oz":
                    ounces = weight ; // 1 ounce = 35.274 grams
                    grams = weight*28.35;
                    milligrams = weight * 28349.5;
                    pounds = weight/ 16; // 1 pound = 16 ounces
                    kilograms = weight / 35.274;
                    metricTons = weight/ 35270;
                    break;
                case "ton":
                    metricTons = weight ; // 1 ton = 1000 kilograms
                    kilograms = weight / 1000;
                    grams = kilograms * 1000;
                    milligrams = grams * 1000;
                    pounds = weight* 2205;
                    ounces = weight*35270;
                    break;
            }

        }
        kg.setText(String.valueOf(String.format("%.6f", kilograms)) );
        gram.setText(String.valueOf(String.format("%.6f", grams)) );
        mg.setText(String.valueOf(String.format("%.6f", milligrams)) );
        pound.setText(String.valueOf(String.format("%.6f", pounds)) );
        oz.setText(String.valueOf(String.format("%.6f", ounces)) );
        ton.setText(String.valueOf(String.format("%.6f", metricTons)) );

    }

    private void changeStatusBarColor (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#E16063"));
        }
    }
}