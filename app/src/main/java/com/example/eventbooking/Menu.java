package com.example.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;


public class Menu extends AppCompatActivity implements View.OnClickListener{
    private CardView btn_payment_menu , btn_question_menu , btn_student_material_menu , btn_notes_menu , btn_announcement_menu , btn_calculator_menu ,btn_support_service_menu ,  btn_logout_menu;
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
        btn_payment_menu = (CardView) findViewById(R.id.btn_payment_menu);
        btn_question_menu = (CardView) findViewById(R.id.btn_question_menu);
        btn_student_material_menu = (CardView) findViewById(R.id.btn_student_material_menu);
        btn_notes_menu = (CardView) findViewById(R.id.btn_notes_menu);
        btn_announcement_menu = (CardView) findViewById(R.id.btn_announcement_menu);
        btn_calculator_menu = (CardView) findViewById(R.id.btn_calculator_menu);
        btn_support_service_menu = (CardView) findViewById(R.id.btn_support_service_menu) ;
        //btn_logout_menu = (CardView) findViewById(R.id.btn_logout_menu);

        //Add Click listener to the cards
        btn_payment_menu.setOnClickListener(this);
        btn_question_menu.setOnClickListener(this);
        btn_student_material_menu.setOnClickListener(this);
        btn_notes_menu.setOnClickListener(this);
        btn_announcement_menu.setOnClickListener(this);
        btn_calculator_menu.setOnClickListener(this);
        btn_support_service_menu.setOnClickListener(this);
        //btn_logout_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;
        switch(v.getId()){
            //case R.id.btn_payment_menu: i = new Intent(this , Payment.class) ; startActivity(i) ; break ;
            //case R.id.btn_question_menu: i = new Intent(this , QestioBox.class) ; startActivity(i) ; break ;
            //case R.id.btn_student_material_menu: i = new Intent(this , StudyMaterials.class) ; startActivity(i) ; break ;
            //case R.id.btn_notes_menu: i = new Intent(this , ActivityNote.class) ; startActivity(i) ; break ;
            //case R.id.btn_announcement_menu: i = new Intent(this , Announcement_Student_View.class) ; startActivity(i) ; break ;
            //case R.id.btn_calculator_menu: i = new Intent(this , calcuator.class) ; startActivity(i) ; break ;
            case R.id.btn_support_service_menu: i = new Intent(this , MainActivity.class) ; startActivity(i) ; break ;
            //case R.id.btn_logout_menu: i = new Intent(this , Bank.class) ; startActivity(i) ; break ;

        }

    }
}