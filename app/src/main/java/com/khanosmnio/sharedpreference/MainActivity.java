package com.khanosmnio.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView productTitle,productPrice;
    private EditText editProTitle,editProPrice;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);
        editProTitle = findViewById(R.id.edit_Pro_title);
        editProPrice = findViewById(R.id.edit_Pro_price);

        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pTitle = editProTitle.getText().toString();
                String pPrice = editProPrice.getText().toString();

                SharedPreferences sharedPreferences;
                sharedPreferences = getSharedPreferences("product_details",MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("p_title",pTitle);
                editor.putString("p_price",pPrice);
                editor.apply();

                productTitle.setText(pTitle);
                productPrice.setText(pPrice);
            }
        });

        //Get the value of SharedPreference
        SharedPreferences getDataFromSharedPreference = getSharedPreferences("product_details",MODE_PRIVATE);

        String title = getDataFromSharedPreference.getString("p_title","Panjabi");
        String price = getDataFromSharedPreference.getString("p_price","2000");

        productTitle.setText(title);
        productPrice.setText(price);





    }
}