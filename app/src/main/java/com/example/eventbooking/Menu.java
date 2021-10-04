package com.example.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;


public class Menu extends AppCompatActivity implements View.OnClickListener{
    private CardView btn_event_booking_menu , btn_room_booking_menu , btn_order_food_menu , btn_logout_menu;
    FirebaseAuth auth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_logout_menu = (CardView) findViewById(R.id.btn_logout_menu);
        btn_logout_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext() , Login.class));
                finish();
            }
        });

        //defining Cards
        btn_logout_menu = (CardView) findViewById(R.id.btn_logout_menu);
        btn_order_food_menu = (CardView) findViewById(R.id.btn_order_food_menu);
        btn_room_booking_menu = (CardView) findViewById(R.id.btn_room_booking_menu);
        btn_event_booking_menu = (CardView) findViewById(R.id.btn_event_booking_menu) ;
        //btn_logout_menu = (CardView) findViewById(R.id.btn_logout_menu);

        //Add Click listener to the cards
        btn_event_booking_menu.setOnClickListener(this);
        btn_room_booking_menu.setOnClickListener(this);
        btn_order_food_menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i ;
        switch(v.getId()){
            case R.id. btn_event_booking_menu: i = new Intent(this , MainActivity.class) ; startActivity(i) ; break ;
            //case R.id.btn_room_booking_menu: i = new Intent(this , QestioBox.class) ; startActivity(i) ; break ;
            //case R.id.btn_order_food_menu: i = new Intent(this , StudyMaterials.class) ; startActivity(i) ; break ;



        }

    }
}