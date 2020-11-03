package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class Sqlite extends SQLiteOpenHelper {
    public static final String DATANAME = "name";
    public static final int DATAVERSAIN = 1;
    public static final String CALLED_CAR = "car";
    public static final String NAME_CAR = "name";
    public static final String AGE_CAR = "age";
    public static final String ID_CAR = "id";
    public Sqlite(Context context) {
        super(context, DATANAME, null, DATAVERSAIN);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // يتم استدعائها عند استخدام الدتا بيز اي انشائها
        // الان تم انشاء الجدول علي قاعده البيانات
        sqLiteDatabase.execSQL("CREATE TABLE " + CALLED_CAR + "  (" + ID_CAR + " INTEGER PRIMARY KEY AUTOINCREMENT , " + " " + NAME_CAR + " TEXT , " + "" +
                " " + AGE_CAR + " TEXT )      ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // يتم انشائها عند التحديث في الداتا بيز اي تغيير الفيرجين versine
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS car");
        onCreate(sqLiteDatabase);
    }

    // داله الاضافه
    public boolean getCar(Car car) {
        SQLiteDatabase sq = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_CAR , car.getId());
        values.put(NAME_CAR, car.getName());
        values.put(AGE_CAR, car.getAge());
        Long result = sq.insert(CALLED_CAR, null, values);
        return result != 1;
    }


    // داله استرجاع
    ArrayList<Car> getAllCar() {
        ArrayList<Car> carArrayList = new ArrayList<>();
        SQLiteDatabase fs = getReadableDatabase();
        Cursor cursor = fs.rawQuery("SELECT * FROM " + CALLED_CAR, null); // قومنا ب تحديد كل الموجود ف الداتا ف المتغير

        if ( cursor!= null && cursor.moveToFirst())
            do {
                int id = cursor.getInt(cursor.getColumnIndex(ID_CAR));
                String name = cursor.getString(cursor.getColumnIndex(NAME_CAR));
                String age = cursor.getString(cursor.getColumnIndex(AGE_CAR));
            }
            while (cursor.moveToNext()) ;
        cursor.close();
        return carArrayList;
    }
}



