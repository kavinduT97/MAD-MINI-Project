package com.example.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText name , email ,  password , confirm_password;
    Button btn_register , btn_login_register_ui ;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    boolean valid = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_reg_password);
        confirm_password = findViewById(R.id.et_reg_confirm_password);
        btn_register = findViewById(R.id.btn_register);
        btn_login_register_ui = findViewById(R.id.btn_login_register_ui);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        btn_login_register_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , Login.class));
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(name);
                checkField(email);

                checkField(password);
                checkField(confirm_password);




                if(valid){
                    //start the registration process
                    fAuth.createUserWithEmailAndPassword(email.getText().toString() , password
                            .getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(Register.this , "Account Created" , Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("User").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("User Name" ,name.getText().toString());
                            userInfo.put("User Email" , email.getText().toString());
                            userInfo.put("User Password" , password.getText().toString());

                            df.set( userInfo);

                            // send student to next page
                            startActivity(new Intent(getApplicationContext() , Menu.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull  Exception e) {
                            Toast.makeText(Register.this , e.getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });
    }

    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false ;
        } else{
            valid = true;
        }

        return valid;
    }
}