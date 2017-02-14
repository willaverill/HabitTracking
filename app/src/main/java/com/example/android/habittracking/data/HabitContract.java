package com.example.android.habittracking.data;

import android.provider.BaseColumns;

/**
 * Created by Will on 2/6/2017.
 */

public final class HabitContract {
    private HabitContract() {}

    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_HOURS = "hours";
        public static final String COLUMN_HABIT_MINUTES = "minutes";
    }
}
