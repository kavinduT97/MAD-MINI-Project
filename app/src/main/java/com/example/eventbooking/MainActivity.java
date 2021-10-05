package com.example.eventbooking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> event_id, event_category, event_guests, event_date, event_time, event_venue;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        event_id = new ArrayList<>();
        event_category = new ArrayList<>();
        event_guests = new ArrayList<>();
        event_date = new ArrayList<>();
        event_time = new ArrayList<>();
        event_venue = new ArrayList<>();

        StoreDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this, event_id, event_category, event_guests, event_date, event_time,
                event_venue);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void StoreDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                event_id.add(cursor.getString(0));
                event_category.add(cursor.getString(1));
                event_guests.add(cursor.getString(2));
                event_date.add(cursor.getString(3));
                event_time.add(cursor.getString(4));
                event_venue.add(cursor.getString(5));

            }
        }
    }
}