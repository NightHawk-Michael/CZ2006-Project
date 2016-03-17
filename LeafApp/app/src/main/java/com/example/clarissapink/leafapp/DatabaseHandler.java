package com.example.clarissapink.leafapp;


        import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.clarissapink.leafapp.models.HDBFlat;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "hdb.db";

    // Contacts table name
    private static final String TABLE_HDB = "hdb_table";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_YEAR = "financial_year";
    private static final String KEY_TOWN = "town";
    private static final String KEY_ROOM = "room_type";
    private static final String KEY_MIN_SELL = "min_selling_price";
    private static final String KEY_MAX_SELL = "max_selling_price";
    private static final String KEY_MIN_SELL_LESS = "min_selling_price_less_ahg_shg";
    private static final String KEY_MAX_SELL_LESS = "max_selling_price_less_ahg_shg";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HDB_TABLE = "CREATE TABLE " + TABLE_HDB + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_YEAR + " INTEGER,"
                + KEY_TOWN + " TEXT," + KEY_ROOM + " TEXT," +  KEY_MIN_SELL + " TEXT," + KEY_MAX_SELL + " TEXT," +
                KEY_MIN_SELL_LESS + " TEXT," + KEY_MAX_SELL_LESS + " TEXT" + ")";
        db.execSQL(CREATE_HDB_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HDB);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new HDB flat
    void addHDB(HDBFlat hdb) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, hdb.getId());
        values.put(KEY_YEAR, hdb.getYear());
        values.put(KEY_TOWN, hdb.getTown());
        values.put(KEY_ROOM, hdb.getRoomType());
        values.put(KEY_MIN_SELL, hdb.getMinPrice());
        values.put(KEY_MAX_SELL, hdb.getMaxPrice());
        values.put(KEY_MIN_SELL_LESS, hdb.getMinPriceLess());
        values.put(KEY_MAX_SELL_LESS, hdb.getMaxPriceLess());

        // Inserting Row
        db.insert(TABLE_HDB, null, values);
        db.close(); // Closing database connection
    }

    // Getting single HDB flat
    public HDBFlat getHDB(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HDB, new String[] { KEY_ID,
                        KEY_YEAR, KEY_TOWN, KEY_ROOM, KEY_MIN_SELL, KEY_MAX_SELL
                        , KEY_MIN_SELL_LESS, KEY_MAX_SELL_LESS}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        HDBFlat hdb = new HDBFlat(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), cursor.getString(2)
                , cursor.getString(3), cursor.getString(4), cursor.getString(5)
                , cursor.getString(6), cursor.getString(7));
        // return hdb
        return hdb;
    }

    // Getting All HDB flats
    public List<HDBFlat> getAllHDB() {
        List<HDBFlat> hdbList = new ArrayList<HDBFlat>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HDB;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HDBFlat hdb = new HDBFlat();
                hdb.setId(Integer.parseInt(cursor.getString(0)));
                hdb.setYear(Integer.parseInt(cursor.getString(1)));
                hdb.setTown(cursor.getString(2));
                hdb.setRoomType(cursor.getString(3));
                hdb.setMinPrice(cursor.getString(4));
                hdb.setMaxPrice(cursor.getString(5));
                hdb.setMinPriceLess(cursor.getString(6));
                hdb.setMaxPriceLess(cursor.getString(7));

                // Adding hdb to list
                hdbList.add(hdb);
            } while (cursor.moveToNext());
        }

        // return hdb list
        return hdbList;
    }

    // UPDATE, DELETE AND COUNT ARE COMMENTED OUR FOR NOW BECAUSE IT IS NOT USED IN OUR APP

//    // Updating single Hdb
//    public int updateHDB(HDBFlat hdb) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(KEY_ID, hdb.getId());
//        values.put(KEY_YEAR, hdb.getYear());
//        values.put(KEY_TOWN, hdb.getTown());
//        values.put(KEY_ROOM, hdb.getRoomType());
//        values.put(KEY_MIN_SELL, hdb.getMinPrice());
//        values.put(KEY_MAX_SELL, hdb.getMaxPrice());
//        values.put(KEY_MIN_SELL_LESS, hdb.getMinPriceLess());
//        values.put(KEY_MAX_SELL_LESS, hdb.getMaxPriceLess());
//
//        // updating row
//        return db.update(TABLE_HDB, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(hdb.getId()) });
//    }
//
//    // Deleting single contact
//    public void deleteContact(HDBFlat hdb) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_HDB, KEY_ID + " = ?",
//                new String[] { String.valueOf(hdb.getId()) });
//        db.close();
//    }
//
//
//    // Getting contacts Count
//    public int getHDBCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_HDB;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }

}