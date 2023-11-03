package com.example.splash_r1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    TextView tvHeader;
    ImageView ivCall, ivURl, ivAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();

        Bundle data = getIntent().getExtras();

        String name, phone, address, url;
        name = data.getString("name", "");
        phone = data.getString("phone", "");
        address = data.getString("address", "");
        url = data.getString("url", "");

        if(!name.isEmpty())
             tvHeader.setText("Welcome "+name);

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!phone.isEmpty()) {
                   Intent intent = new Intent(Intent.ACTION_DIAL);
                   intent.setData(Uri.parse("tel:" + phone));
                   startActivity(intent);
               }
               else {
                   Toast.makeText(ShowActivity.this, "No phone number assigned", Toast.LENGTH_SHORT).show();
               }
            }
        });

        ivAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!address.isEmpty())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:(0,0)?q=" + Uri.encode(address)));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ShowActivity.this, "No address assigned", Toast.LENGTH_SHORT).show();

                }
            }
        });

        ivURl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!url.isEmpty())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ShowActivity.this, "No url assigned", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void init()
    {
        tvHeader = findViewById(R.id.tvHeader);
        ivAddress = findViewById(R.id.ivAddress);
        ivCall = findViewById(R.id.ivCall);
        ivURl = findViewById(R.id.ivUrl);
    }
}