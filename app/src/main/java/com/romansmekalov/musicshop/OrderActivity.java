package com.romansmekalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses ={"romansmekalov@gmail.com"};
    String subject="Order from Music  Shop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("You Order");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = receivedOrderIntent.getStringExtra("goodsNameForIntent");
        int quantity = receivedOrderIntent.getIntExtra("quantityForIntent", 0);
        double price = receivedOrderIntent.getDoubleExtra("priceForIntent",0);
        double orderFullPrice = receivedOrderIntent.getDoubleExtra("orderPriceForIntent",0);

        TextView orderUsernameTextView = findViewById(R.id.orderUsernameTextView);
        orderUsernameTextView.setText(userName);

        TextView orderGoodsnameTextView = findViewById(R.id.orderGoodsviewTextView);
        orderGoodsnameTextView.setText(goodsName);

        TextView orderQuantityTextView = findViewById(R.id.orderQuantityTextView);
        orderQuantityTextView.setText(""+quantity);

        TextView orderPriceTextView = findViewById(R.id.orderPriceTextView);
        orderPriceTextView.setText(""+price);

        TextView orderFullPriceTextView = findViewById(R.id.orderFullPriceTextView);
        orderFullPriceTextView.setText(""+orderFullPrice);

        emailText = "Customer name: "+userName+"\n"+"Goods name: "+goodsName+"\n"+"Quantity: "+quantity+"\n"+"Price: "+price+"\n"+"Order Price: "+orderFullPrice;
    }

    public void submitOrder(View view) {

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*"); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
