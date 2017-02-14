package com.example.android.habittracking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.habittracking.data.HabitContract;
import com.example.android.habittracking.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    public HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
    }

    public long insert(String name, int hours, int minutes) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, name);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_HOURS, hours);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_MINUTES, minutes);

        return db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor read () {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String [] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_HOURS,
                HabitContract.HabitEntry.COLUMN_HABIT_MINUTES
        };

        return db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}
