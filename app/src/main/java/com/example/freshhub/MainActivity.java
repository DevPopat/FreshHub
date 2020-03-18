package com.example.freshhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInventory;
    Button btnViewProfile;
    Button btnContactUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInventory = findViewById(R.id.btnInventory);
        btnViewProfile = findViewById(R.id.btnViewProfile);
        btnContactUs = findViewById(R.id.btnContactUs);
        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inventory.class);
                startActivity(intent);
                finish();
            }
        });
        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserProfile.class);
                startActivity(intent);
                finish();
            }
        });
        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContactUs.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
