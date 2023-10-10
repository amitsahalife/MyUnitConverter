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

public class storageUnit extends AppCompatActivity {
    EditText input;
    Spinner unit;
    private TextView textViewBit;
    private TextView textViewByte;
    private TextView textViewKB;
    private TextView textViewMB;
    private TextView textViewGB;
    private TextView textViewTB;
    private TextView textViewPB;
    private TextView textViewEB;
    private TextView textViewZB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_unit);
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        textViewByte = findViewById(R.id.bytee);
        textViewBit =  findViewById(R.id.bit);
        textViewKB =  findViewById(R.id.kb);
        changeStatusBarColor();
        textViewMB =  findViewById(R.id.mb);
        textViewGB =  findViewById(R.id.gb);
        textViewTB =  findViewById(R.id.tb);
        textViewPB =  findViewById(R.id.pb);
        textViewEB =  findViewById(R.id.eb);
        textViewZB =  findViewById(R.id.zb);

        String [] arr ={"KB","MB","GB","TB","BIT","BYTE","PB","EB","ZB"};
        unit.setAdapter(new ArrayAdapter(   storageUnit.this, android.R.layout.simple_list_item_1, arr));
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
        double Bit = 0;
        double Byte = 0;
        double KB = 0;
        double MB = 0;
        double GB = 0;
        double TB = 0;
        double PB = 0;
        double EB = 0;
        double ZB = 0;
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double storage = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "BIT":
                    Bit = storage;
                    Byte = Bit / 8;
                    KB = Byte / 1024;
                    MB = KB / 1024;
                    GB = MB / 1024;
                    TB = GB / 1024;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "BYTE":
                    Byte = storage;
                    Bit = Byte * 8;
                    KB = Byte / 1024;
                    MB = KB / 1024;
                    GB = MB / 1024;
                    TB = GB / 1024;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "KB":
                    KB = storage;
                    Byte = storage * 1000;
                    Bit = storage * 8000;
                    MB = storage / 1000;
                    GB = storage/ 125000;
                    TB = GB / 1024;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "MB":
                    MB = storage;
                    KB = storage * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    GB = MB / 1024;
                    TB = GB / 1024;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "GB":
                    GB = storage;
                    MB = GB * 1024;
                    KB = MB * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    TB = storage/ 1024;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "TB":
                    TB = storage;
                    GB = TB * 1024;
                    MB = GB * 1024;
                    KB = MB * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    PB = TB / 1024;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "PB":
                    PB = storage;
                    TB = PB * 1024;
                    GB = TB * 1024;
                    MB = GB * 1024;
                    KB = MB * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    EB = PB / 1024;
                    ZB = EB / 1024;
                    break;
                case "EB":
                    EB = storage;
                    PB = EB * 1024;
                    TB = PB * 1024;
                    GB = TB * 1024;
                    MB = GB * 1024;
                    KB = MB * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    ZB = EB / 1024;
                    break;
                case "ZB":
                    ZB = storage;
                    EB = ZB * 1024;
                    PB = EB * 1024;
                    TB = PB * 1024;
                    GB = TB * 1024;
                    MB = GB * 1024;
                    KB = MB * 1024;
                    Byte = KB * 1024;
                    Bit = Byte * 8;
                    break;

            }
            textViewByte.setText(String.format(" %.2fB", Byte));
            textViewKB.setText(String.format(" %.2fKB", KB));
            textViewMB.setText(String.format(" %.2fMB", MB));
            textViewGB.setText(String.format(" %.2fGB", GB));
            textViewBit.setText(String.format("%.2fb", Bit));
            textViewPB.setText(String.format("%.2fPB", PB));
            textViewEB.setText(String.format("%.2fEB", EB));
            textViewZB.setText(String.format("%.2fZB", ZB));


            textViewTB.setText(String.format(" %.2fTB", TB));
        }
    }
    private void changeStatusBarColor (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#96C1A8"));
        }
    }
}