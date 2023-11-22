package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBook extends AppCompatActivity {

    EditText edName,edAddress,edContact,edPincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edName = findViewById(R.id.editTextBMBFullName);
        edAddress = findViewById(R.id.editTextBMBAddress);
        edContact = findViewById(R.id.editTextBMBContactNumber);
        edPincode = findViewById(R.id.editTextBMBPinCode);
        btnBooking = findViewById(R.id.buttonBMBBook);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username, edName.getText().toString(),edAddress.getText().toString(),edContact.getText().toString(),Integer.parseInt(edPincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removeFromCart(username,"medicine");

                Toast.makeText(getApplicationContext(),"Your Booking is done succesfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBook.this,Home.class));
            }
        });

    }
}