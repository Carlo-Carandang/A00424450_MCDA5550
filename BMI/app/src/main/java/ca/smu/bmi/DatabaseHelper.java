package ca.smu.bmi;

import android.app.TaskStackBuilder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

/**
 * Created by carlocarandang on 2018-02-11.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

/*    public static final String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "DOB";
    public static final String COL4 = "HEALTH_NUM";
    public static final String COL5 = "PASSWORD";
*/
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
/*        String createTable = "CREATE TABLE" + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " + "DOB DATE, " + "HEALTH_NUM TEXT, " + "PASSWORD TEXT)"; */
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists record");
        db.execSQL("Create table user(nameTxt text,dobText text,healthcardTxt text,passwordTxt text)");
        db.execSQL("Create table record(nameTxt text,dateText text,heightTxt integer,weightTxt integer,BMI integer)");


        Date today = new Date(); // we want to start with some initial data
        ContentValues personValues = new ContentValues();
        personValues.put("nameTxt", "Carlo Carandang");
        personValues.put("dobTxt", "05/01/1990");
        personValues.put("healthcardTxt", "1234");
        personValues.put("passwordTxt", "qwerty");
        db.insert("user",null, personValues);
        ContentValues recordValues = new ContentValues();
        recordValues.put("nameTxt","Carlo Carandang");
        recordValues.put("dateText","01/01/2018");
        recordValues.put("heightTxt",2);
        recordValues.put("weightTxt",70);
        recordValues.put("BMI", 18);
        db.insert("record", null, recordValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists record");
/*        onCreate(db); */
    }
    //inserting into database
    public boolean insert(String nameTxt, String dobTxt, String healthcardTxt, String passwordTxt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameTxt",nameTxt);
        contentValues.put("dobTxt",dobTxt);
        contentValues.put("healthcardTxt",healthcardTxt);
        contentValues.put("passwordTxt",passwordTxt);
        long ins = db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //checking if name exists
    public Boolean checkname(String nameTxt){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where nameTxt=?",new String[]{nameTxt});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //check the email and password
    public Boolean namepassword(String nameTxt, String passwordTxt){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where nameTxt=? and passwordTxt=?",new String[]{nameTxt,passwordTxt});
        if(cursor.getCount()>0) return true;
        else return false;
    }

/*    public boolean addData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    } */
/*
    public boolean addData(String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, dob);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addData(String health_num) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, health_num);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addData(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5, password);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
*/
    /* returns all the data from the database @return
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    } */

}
