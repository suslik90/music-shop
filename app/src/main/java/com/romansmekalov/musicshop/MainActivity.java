package com.romansmekalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
