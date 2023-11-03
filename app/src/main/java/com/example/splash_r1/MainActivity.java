package com.example.splash_r1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etName, etPhone, etAddress, etUrl;
    Button btnCancel, btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, phone, address, url;
                name = etName.getText().toString().trim();
                phone = etPhone.getText().toString().trim();
                url = etUrl.getText().toString().trim();
                address = etAddress.getText().toString().trim();

                Intent i = new Intent(MainActivity.this, ShowActivity.class);


                i.putExtra("name", name);
                i.putExtra("phone", phone);
                i.putExtra("address", address);
                i.putExtra("url", url);

                startActivity(i);
                finish();

            }
        });
    }

    public void init()
    {
        etName = findViewById(R.id.etUsername);
        etAddress = findViewById(R.id.etAddress);
        etUrl = findViewById(R.id.etUrl);
        etPhone = findViewById(R.id.etPhoneNumber);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

}