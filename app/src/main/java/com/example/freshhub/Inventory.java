package com.example.freshhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends AppCompatActivity {
    public static final String TAG = "Inventory";
    protected RecyclerView rvFoods;
    protected List<Food> allFoods;
    FoodAdapter adapter;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        allFoods = new ArrayList<>();
        adapter = new FoodAdapter(this,R.layout.item_food,allFoods);
        btnBack = findViewById(R.id.btnBack);
        rvFoods = findViewById(R.id.rvFoods);
        rvFoods.setAdapter(adapter);
        rvFoods.setLayoutManager(new LinearLayoutManager(this));

        ParseQuery<Food> foodQuery = new ParseQuery<Food>(Food.class);

        foodQuery.findInBackground(new FindCallback<Food>() {
            @Override
            public void done(List<Food> objects, ParseException e) {
                if (e!=null){
                    Log.e(TAG,"Error with query",e);
                    return;
                }
                Log.i(TAG,"getting with query");
                allFoods.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
