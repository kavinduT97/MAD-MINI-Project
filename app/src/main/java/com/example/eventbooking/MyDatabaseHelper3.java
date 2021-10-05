package com.example.eventbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper3 extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "RoomBooking.db";
    private static final int DATABASE_VERSION = 1 ;

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CHECKINDATE = "check_in_date";
    private static final String COLUMN_CHECKOUTDATE = "check_out_date";
    private static final String COLUMN_PACKAGE = " package ";
    private static final String COLUMN_NOOFROOMS = "no_of_rooms";
    private static final String COLUMN_PREFERENCE = "preference";



    public MyDatabaseHelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CHECKINDATE + " TEXT, " +
                        COLUMN_CHECKOUTDATE + " TEXT, " +
                        COLUMN_PACKAGE + " TEXT, " +
                        COLUMN_NOOFROOMS + " TEXT, " +
                        COLUMN_PREFERENCE + " EXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    void bookroom(String checkInDate , String checkOutDate ,String packag , String number ,
                  String preference ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CHECKINDATE,checkInDate);
        cv.put(COLUMN_CHECKOUTDATE,checkOutDate);
        cv.put(COLUMN_PACKAGE, packag);
        cv.put(COLUMN_NOOFROOMS,number);
        cv.put(COLUMN_PREFERENCE,preference);
        long result = db.insert(TABLE_NAME, null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Booking Successful", Toast.LENGTH_SHORT).show();
        }


    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
