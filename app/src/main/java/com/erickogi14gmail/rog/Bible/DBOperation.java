package com.erickogi14gmail.rog.Bible;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 7/28/2017.
 */

public class DBOperation {

    private DbClass dbHandler;
    Context context;

    public DBOperation(Context context) {
        dbHandler = new DbClass(context);
        this.context=context;
    }


    public ArrayList<BiblePojo> getList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM  t_kjv" ;


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                BiblePojo pojo = new BiblePojo();


                pojo.setId(cursor.getInt(0));
                pojo.setB(cursor.getInt(1));
                pojo.setC(cursor.getInt(2));
                pojo.setV(cursor.getInt(3));
                pojo.setT(cursor.getString(4));

                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;


    }
    public boolean insert(String query){


        try {

            SQLiteDatabase db = dbHandler.getWritableDatabase();
            db.execSQL(query);

            return true;
        }
        catch (Exception m){
            Log.d("jk",""+m);
            Toast.makeText(context, ""+m, Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public ArrayList<BiblePojo> getList(int book,int chapter,int verse){
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM  t_kjv  WHERE b ='"+book+"' AND c ='"+chapter+"' AND v ='"+verse+"'" ;


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                BiblePojo pojo = new BiblePojo();


                pojo.setId(cursor.getInt(0));
                pojo.setB(cursor.getInt(1));
                pojo.setC(cursor.getInt(2));
                pojo.setV(cursor.getInt(3));
                pojo.setT(cursor.getString(4));

                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;
    }


}
