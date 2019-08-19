package com.android.loonies.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.loonies.R;

public class LoginActivity  extends AppCompatActivity {

    LinearLayout alertContainer;
    TextView errorText;
    TextView signUpButton;
    TextView forgotPasswordText;
    EditText passwordText;
    EditText emailText;
    Button loginButton;
    String email;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                 Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                 startActivity(intent);
            }
        });


        email = emailText.getText().toString().trim();
        password = passwordText.getText().toString();


    }





    private void initViews() {

        alertContainer = findViewById(R.id.container_alert);
        errorText = findViewById(R.id.text_error);
        emailText = findViewById(R.id.edit_emailText);
        loginButton = findViewById(R.id.button_login);
        signUpButton = findViewById(R.id.text_sign_up);
        forgotPasswordText = findViewById(R.id.text_forgot_password);
        passwordText = findViewById(R.id.password_text);

    }
}
