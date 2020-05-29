    package com.joan.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

    public class ListProductsActivity extends AppCompatActivity {

    //Call Database class connection
    //Database market;
    //Create a ListView variable
    private ListView productList;
    //Create an array list variable
    ArrayList<String> listItem;
    //Create an adapter variable
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        //Create an empty array
        listItem = new ArrayList<>();

        //Get ListView component GUI ID
        productList = findViewById(R.id.lvListProducts);

        //LoadData
        viewProducts();
    }

    //This method lists all products in ListView
    private void viewProducts() {
        //Connect to DB
        Database manager = new Database(
                this,
                "market",
                null,
                1
        );

        //Let read/write in DB
        SQLiteDatabase market = manager.getWritableDatabase();

        //Query
        Cursor row = market.rawQuery("SELECT * FROM products", null);

        if (row.getCount() == 0) {
            Toast.makeText(this, "::: There aren't any products :::", Toast.LENGTH_SHORT).show();
        } else {
            while (row.moveToNext()) {
                listItem.add(row.getString(1));
                listItem.add(row.getString(2));
                listItem.add(row.getString(3));
                listItem.add(row.getString(4));
            }
            adapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_dropdown_item_1line,
                    listItem
            );
            productList.setAdapter(adapter);
        }

    }
}
