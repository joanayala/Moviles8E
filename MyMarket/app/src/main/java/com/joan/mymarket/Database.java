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
                "id integer primary key autoincrement not null, " +
                "email text not null unique, " +
                "password text not null)"
        );
        market.execSQL("INSERT INTO " +
                "users (email, password) " +
                "values('admin','1234')"
        );
        market.execSQL("CREATE TABLE products (" +
                "id integer primary key autoincrement not null, " +
                "prod_name text not null, " +
                "description text not null," +
                "unit_price float not null," +
                "quantity int not null)"
        );
        market.execSQL("INSERT INTO " +
                "products (prod_name, description, unit_price, quantity) " +
                "values('TENNIS','TENNIS ADIDAS WHITE T40',100000,50)"
        );
        market.execSQL("INSERT INTO " +
                "products (prod_name, description, unit_price, quantity) " +
                "values('TENNIS','TENNIS ADIDAS BLACK T40',120000,100)"
        );
        market.execSQL("INSERT INTO " +
                "products (prod_name, description, unit_price, quantity) " +
                "values('JACKET','JACKET BLUE&BLUE TM',80000,30)"
        );
        market.execSQL("CREATE TABLE cities (" +
                "id integer primary key autoincrement not null, " +
                "city_name text not null, " +
                "description text not null," +
                "abrev text not null)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
