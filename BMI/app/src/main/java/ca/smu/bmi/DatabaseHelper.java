package ca.smu.bmi;

import android.app.TaskStackBuilder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.FloatProperty;
import android.util.Log;

import java.util.Date;

/**
 * Created by carlocarandang on 2018-02-11.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //to prevent create table errors, increase the database version
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
/*        String createTable = "CREATE TABLE" + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " + "DOB DATE, " + "HEALTH_NUM TEXT, " + "PASSWORD TEXT)"; */

        db.execSQL("CREATE TABLE USER (NAMETXT TEXT PRIMARY KEY, DOBTXT TEXT, HEALTHCARDTXT TEXT, PASSWORDTXT TEXT)");
        db.execSQL("CREATE TABLE RECORD (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATETXT TEXT, HEIGHTTXT REAL, WEIGHTTXT REAL, BMI REAL)");

        Date today = new Date(); // we want to start with some initial data
        ContentValues personValues = new ContentValues();
        personValues.put("NAMETXT", "Carlo Carandang");
        personValues.put("DOBTXT", "05/01/1990");
        personValues.put("HEALTHCARDTXT", "1234");
        personValues.put("PASSWORDTXT", "qwerty");
        db.insert("USER",null, personValues);

        ContentValues recordValues = new ContentValues();
        recordValues.put("DATETXT","01/01/2018");
        recordValues.put("HEIGHTTXT",2);
        recordValues.put("WEIGHTTXT",70);
        recordValues.put("BMI", 18);
        db.insert("RECORD", null, recordValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS RECORD");
        onCreate(db);
    }

    //inserting registration data into database
    public boolean insert(String nameTxt, String dobTxt, String healthcardTxt, String passwordTxt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAMETXT",nameTxt);
        contentValues.put("DOBTXT",dobTxt);
        contentValues.put("HEALTHCARDTXT",healthcardTxt);
        contentValues.put("PASSWORDTXT",passwordTxt);
        long ins = db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //checking if name exists
    public boolean checkname(String nameTxt){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE NAMETXT=?",new String[]{nameTxt});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //check the email and password
    public boolean namepassword(String nameTxt, String passwordTxt){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE NAMETXT=? and PASSWORDTXT=?",new String[]{nameTxt,passwordTxt});
        if(cursor.getCount()>0) return true;
        else return false;
    }
    //inserting BMI data into database
    public boolean insertinrecord(String r1, Float r2, Float r3, Float r4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATETXT",r1);
        contentValues.put("HEIGHTTXT",r2);
        contentValues.put("WEIGHTTXT",r3);
        contentValues.put("BMI",r4);
        long result = db.insert("RECORD", null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM RECORD",null);
        return result;
    }

    //updating password
    public int UpdatePassword(String nameTxt, String passwordTxt) {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for password column
        ContentValues contentValues = new ContentValues();
        contentValues.put("PASSWORDTXT", passwordTxt);

        // Which row to update, based on the NAMETXT column
        String selection = "NAMETXT = ?";
        String[] selectionArgs = { String.valueOf(nameTxt) };

        int count = db.update("USER", contentValues, selection, selectionArgs);

        //Return how many rows updated
        return count;
    }
}
