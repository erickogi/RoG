package com.erickogi14gmail.rog.Bible;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimani kogi on 7/28/2017.
 */

public class DbClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "bible.db";
    public DbClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    String createTable="CREATE TABLE `t_kjv` (" +
            "  `id` int(8)  NOT NULL," +
            "  `b` int(11) NOT NULL," +
            "  `c` int(11) NOT NULL," +
            "  `v` int(11) NOT NULL," +
            "  `t` text NOT NULL"
            + ")";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + createTable);



        onCreate(db);
    }
}
