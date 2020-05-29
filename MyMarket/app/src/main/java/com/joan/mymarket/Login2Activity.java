package com.joan.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2Activity extends AppCompatActivity {

    private EditText usrname, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        usrname = findViewById(R.id.txtUsernameLogin);
        passwd = findViewById(R.id.txtPasswordLogin);
    }

    public void btnLogin(View view){
        //Connect to DB
        Database manager = new Database(
                this,
                "market",
                null,
                1
        );

        //Let write and read in DB
        SQLiteDatabase market = manager.getWritableDatabase();

        //Get values
        String USRNAME = usrname.getText().toString();
        String PASSWD = passwd.getText().toString();

        if (USRNAME.isEmpty() || PASSWD.isEmpty()) {
            Toast.makeText(this, "There are some empty fields", Toast.LENGTH_SHORT).show();
            usrname.setError("");
            passwd.setError("");
        } else {
            Cursor row = market.rawQuery(
                    "SELECT * FROM users " +
                            "WHERE email = ? AND password = ? LIMIT 1",
                    new String[]{USRNAME,PASSWD}
            );
            if (row.getCount() < 1) {
                Toast.makeText(this, "::: User was not found :::", Toast.LENGTH_SHORT).show();
                usrname.setError("");
                passwd.setError("");
            } else {
                Intent i = new Intent(this, ListProductsActivity.class);
                startActivity(i);
            }
        }
    }

    public void btnGotoRegisterForm (View view){
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
}
