package com.erickogi14gmail.rog.Bible;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public int getChapters(int book){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        return (int) DatabaseUtils.longForQuery(db,"SELECT MAX(c) FROM t_asv WHERE b =?",new String[]{String.valueOf(book)});
      // return  20;

    }
    public int getVerses(int book,int chapter){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        return (int) DatabaseUtils.longForQuery(db,"SELECT MAX(v) FROM t_asv WHERE b ='"+book+"' AND c =?",new String[]{String.valueOf(chapter)});

        // return  40;
    }
    public ArrayList<BiblePojo> getListOfBooks(int from ,int to) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT b FROM  t_asv  WHERE id BETWEEN '"+from+"'  AND '"+to+"' " ;


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                BiblePojo pojo = new BiblePojo();


                pojo.setId(cursor.getInt(0));
                pojo.setB(cursor.getInt(1));
                pojo.setC(cursor.getInt(2));
                pojo.setV(1);
                pojo.setT("");

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
    public ArrayList<BiblePojo> getBookMarksList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM  bible_bookMarks" ;


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
    public boolean insert( String query){


        try {

            SQLiteDatabase db = dbHandler.getWritableDatabase();

           // query;

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
               //    db.beginTransaction();
//                    Log.d("jklp","dgf");

               //     for(String s:query.split("||")){
            Log.d("nulsd","f"+query);
                        db.execSQL(query);
                      //  Log.d("jklp",s);
               //     }
                     db.close();

                  //  db.setTransactionSuccessful();
                  //  db.endTransaction();
              //  }
          //  }).start();
            return true;
        }
        catch (Exception m){
            m.printStackTrace();
            Log.d("jk",""+m);
            return false;
        }

    }

    public boolean insertBible(BiblePojo data) {
        boolean success = false;

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("id", data.getId());
        values.put("b", data.getB());


        values.put("c", data.getC());
        values.put("v", data.getV());
        values.put("t", data.getT());




        // Inserting Row
        if (db.insert("t_asv", null, values) >= 1) {
            success = true;
        }
        db.close();

    //    }
     //             }).start();
        return success;


    }

    public ArrayList<BiblePojo> getList(int book,int chapter,int verse){

        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM  t_asv  WHERE b ='"+book+"' AND c ='"+chapter+"' " ;


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

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;
    }





    public ArrayList<BiblePojo> getBibleSearch(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<BiblePojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM  t_asv  WHERE t LIKE '%"+search+"%'   " ;


//        Cursor cursor = db.rawQuery("SELECT * FROM  t_asv  WHERE t LIKE ?", new String[]{search});
        Cursor cursor = db.rawQuery(QUERY, null);
        Log.d("poloSe",search);

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




    public boolean insertBookMark( String query){


        try {

            SQLiteDatabase db = dbHandler.getWritableDatabase();

            // query;

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
            //    db.beginTransaction();
//                    Log.d("jklp","dgf");

            //     for(String s:query.split("||")){
            Log.d("nulsd","f"+query);
            db.execSQL(query);
            //  Log.d("jklp",s);
            //     }
            db.close();

            //  db.setTransactionSuccessful();
            //  db.endTransaction();
            //  }
            //  }).start();
            return true;
        }
        catch (Exception m){
            m.printStackTrace();
            Log.d("jk",""+m);
            return false;
        }

    }

    public boolean insertBookMark(BiblePojo data) {
        boolean success = false;

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("id", data.getId());
        values.put("b", data.getB());


        values.put("c", data.getC());
        values.put("v", data.getV());
        values.put("t", data.getT());




        // Inserting Row
        if (db.insert("bible_bookMarks", null, values) >= 1) {
            success = true;
        }
        db.close();


        return success;


    }
    public boolean deleteBookMark(int id) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete("bible_bookMarks", "id" + "= '" + id + "' ", null) > 0;

    }


    public boolean deleteBible() {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete("t_asv",null, null) > 0;
    }
}
