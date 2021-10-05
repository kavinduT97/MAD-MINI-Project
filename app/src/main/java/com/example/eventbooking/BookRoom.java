package com.example.eventbooking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BookRoom extends AppCompatActivity {

    EditText checkinndate_input, checkoutndate_input, packag_input, noofroom_input,preference_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);

        checkinndate_input = findViewById(R.id.checkinndate_input);
        checkoutndate_input = findViewById(R.id.checkoutndate_input);
        packag_input = findViewById(R.id.packag_input);
        noofroom_input = findViewById(R.id.noofroom_input);
        preference_input = findViewById(R.id.preference_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.roombooking.MyDatabaseHelper3 myDB = new com.example.roombooking.MyDatabaseHelper3(BookRoom.this);
                myDB.bookroom(checkinndate_input.getText().toString().trim(),
                                checkoutndate_input.getText().toString().trim(),
                                packag_input.getText().toString().trim(),
                                noofroom_input.getText().toString().trim(),
                                preference_input.getText().toString().trim());

            }
        });

    }
}