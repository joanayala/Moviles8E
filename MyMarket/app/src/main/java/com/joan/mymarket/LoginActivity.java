package com.joan.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user_name;
    private EditText passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.txtUsername);
        passwd = findViewById(R.id.txtPassword);
    }

    public void btnLogin(View view){
        String user = user_name.getText().toString();
        String pass = passwd.getText().toString();

        Toast.makeText(this, "Welcome: " + user + "your password is: " + pass, Toast.LENGTH_SHORT).show();
    }

    public void btnGotoRegisterForm (View view){
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
}
