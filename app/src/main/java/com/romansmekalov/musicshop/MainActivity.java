package com.romansmekalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int cnt = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createMap();

    }

    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this); ;
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }

    void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);
    }

    public void increaseQuantity(View view) {
        updateOrderTotal("+");
    }

    public void decreaseQuantity(View view) {
        updateOrderTotal("-");
    }

    void updateOrderTotal(String action){
        TextView cntView = findViewById(R.id.countItems);

        switch (action){
            case "+":
                cnt++;
                break;
            case "-":
                cnt--;
                break;
        }

        if(cnt < 0) cnt = 0;
        cntView.setText(Integer.toString(cnt));
        TextView orderTotal = findViewById(R.id.orderTotal);
        orderTotal.setText("" + cnt * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView orderTotal = findViewById(R.id.orderTotal);
        orderTotal.setText("" + cnt * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (goodsName){
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsImageView.setImageResource(R.drawable.piano);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
