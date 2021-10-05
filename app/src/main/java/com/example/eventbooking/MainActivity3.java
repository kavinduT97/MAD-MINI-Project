package com.example.eventbooking;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper3 myDB;
    ArrayList<String> book_id, checkindate, checkoutdate, packg, noofrooms, preference;
    CustomAdapter3 customAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, BookRoom.class);
                startActivity(intent);

            }
        });

        myDB = new MyDatabaseHelper3(MainActivity3.this);
        book_id = new ArrayList<>();
        checkindate = new ArrayList<>();
        checkoutdate = new ArrayList<>();
        packg = new ArrayList<>();
        noofrooms = new ArrayList<>();
        preference = new ArrayList<>();

        storeDataInArrays();

        customAdapter3 = new CustomAdapter3(MainActivity3.this, book_id, checkindate, checkoutdate, packg, noofrooms, preference);
        recyclerView.setAdapter(customAdapter3);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                checkindate.add(cursor.getString(1));
                checkoutdate.add(cursor.getString(2));
                packg.add(cursor.getString(3));
                noofrooms.add(cursor.getString(4));
                preference.add(cursor.getString(5));
            }
        }
    }
}