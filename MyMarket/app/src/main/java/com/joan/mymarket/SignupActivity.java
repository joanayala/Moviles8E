package com.joan.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText usrname, passwd, passwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usrname = findViewById(R.id.txtUsername);
        passwd = findViewById(R.id.txtPassword);
        passwd2 = findViewById(R.id.txtPassword2);
    }

    //Method to create a new user
    public void btnSignup(View view){
        //Connect to DB
        Database manager = new Database(
                this,
                "market",
                null,
                1
        );

        //Let write in DB
        SQLiteDatabase market = manager.getWritableDatabase();

        //Get values
        String USRNAME = usrname.getText().toString();
        String PASSWD1 = passwd.getText().toString();
        String PASSWD2 = passwd2.getText().toString();

        if (USRNAME.isEmpty() || PASSWD1.isEmpty() || PASSWD2.isEmpty()){
            Toast.makeText(this, "::: There are empty fields :::", Toast.LENGTH_SHORT).show();
            usrname.setError("");
            passwd.setError("");
            passwd2.setError("");
        } else {
            if (!PASSWD1.equals(PASSWD2)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                passwd.setError("");
                passwd2.setError("");
            } else {
                Cursor row = market.rawQuery(
                        "SELECT * FROM users WHERE email = ? LIMIT 1", new String[]{USRNAME});

                //!row.moveToNext()
                //!row.moveToFirst()
                if (row.getCount() > 0) {
                    Toast.makeText(this,
                            "::: The user already exists :::", Toast.LENGTH_SHORT).show();
                    usrname.setError("");
                } else {
                    ContentValues data = new ContentValues();
                    data.put("email", USRNAME);
                    data.put("password", PASSWD1);
                    market.insert("users", null, data);
                    market.close();

                    Toast.makeText(this, "The user has been created", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Login2Activity.class);
                    startActivity(i);
                }
            }
        }

    }
}
