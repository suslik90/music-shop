package com.romansmekalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int cnt = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void increaseQuantity(View view) {
        TextView cntView = findViewById(R.id.countItems);
        cnt = cnt + 1;
        cntView.setText(Integer.toString(cnt));
    }

    public void decreaseQuantity(View view) {
        TextView cntView = findViewById(R.id.countItems);
        cnt = cnt - 1;
        if(cnt < 0) cnt = 0;
        cntView.setText(Integer.toString(cnt));
    }
}
