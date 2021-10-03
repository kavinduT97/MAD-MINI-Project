package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText event_input, guest_input, date_input, time_input, venue_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        event_input = findViewById(R.id.event_input);
        guest_input = findViewById(R.id.guest_input);
        date_input = findViewById(R.id.date_input);
        time_input = findViewById(R.id.time_input);
        venue_input = findViewById(R.id.venue_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addEvent(event_input.getText().toString().trim(),
                        guest_input.getText().toString().trim(),
                        date_input.getText().toString().trim(),
                        time_input.getText().toString().trim(),
                        venue_input.getText().toString().trim());

            }
        });
    }
}