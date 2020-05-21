package com.joan.mymarket;

//1. Import SQLiteOpenHelper
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        market.execSQL("CREATE TABLE users (" +
                "id int primary key autoincrement not null, " +
                "email text not null, " +
                "password text not null)"
        );
        market.execSQL("CREATE TABLE products (" +
                "id int primary key autoincrement not null, " +
                "prod_name text not null, " +
                "description text not null," +
                "unit_price float not null," +
                "quantity int not null)"
        );
        market.execSQL("INSERT INTO " +
                "products (prod_name, description, unit_price, quantity) " +
                "values('TENNIS','TENNIS ADIDAS WHITE T40',100000,50)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
