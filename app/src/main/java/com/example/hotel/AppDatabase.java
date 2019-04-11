package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

import java.sql.Blob;

public class AppDatabase extends SQLiteOpenHelper {
    private static final String TAG = "AppDatabase";
    public static final String DATABASE_NAME = "HotelAppData03.db";
    public static final int DATABAE_VERSION = 1;


    public AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABAE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            Log.d(TAG, "onCreate: starts");

            String s1 = "CREATE TABLE " + HotelContract.HOTEL_TABLE_NAME + "(" + HotelContract.Columns.HOTEL_ID + " INTEGER PRIMARY KEY NOT NULL, " + HotelContract.Columns.HOTEL_NAME + " TEXT, " + HotelContract.Columns.HOTEL_LOCATION + " TEXT, " + HotelContract.Columns.HOTEL_CONTACT_PERSON + " TEXT, " + HotelContract.Columns.HOTEL_CONTACT_NUMBER + " INTEGER, " + HotelContract.Columns.HOTEL_STAR_RATING + " INTEGER, " + HotelContract.Columns.HOTEL_DESCRIPTION + " TEXT, " + HotelContract.Columns.HOTEL_ROOM_TYPE_1 + " TEXT, " + HotelContract.Columns.HOTEL_ROOM_TYPE_2 + " TEXT, " + HotelContract.Columns.HOTEL_ROOM_TYPE_3 + " TEXT, " + HotelContract.Columns.HOTEL_IMAGES + " byte(1000000))";
            db.execSQL(s1);
            String s2 = "CREATE TABLE " + RoomsContract.ROOM_TABLE_NAME + "(" + RoomsContract.Columns.ROOM_ID + " INTEGER PRIMARY KEY NOT NULL, " + RoomsContract.Columns.ROOM_TYPE1 + " TEXT, " + RoomsContract.Columns.ROOM_TYPE2 + " TEXT, " + RoomsContract.Columns.ROOM_TYPE3 + " TEXT, " + RoomsContract.Columns.HOTEL_ROOM_ID + " INTEGER, " + RoomsContract.Columns.O_NO_OF_ROOMS + " INTEGER, " + RoomsContract.Columns.ORDINARY_ROOM_PRICE + " INTEGER, " + RoomsContract.Columns.ORDINARY_ROOM_DESCRIPTION + " TEXT, " + RoomsContract.Columns.L_NO_OF_ROOMS + " INTEGER, " + RoomsContract.Columns.LUXURY_ROOM_PRICE + " INTEGER, " + RoomsContract.Columns.LUXURY_ROOM_DESCRIPTION + " TEXT, " + RoomsContract.Columns.S_NO_OF_ROOMS + " INTEGER, " + RoomsContract.Columns.SUPERLUXURY_ROOM_PRICE + " INTEGER, " + RoomsContract.Columns.SUPERLUXURY_ROOM_DESCRIPTION + " TEXT, " + RoomsContract.Columns.ROOM1_IMAGE + " byte(10000000), " + RoomsContract.Columns.ROOM2_IMAGE + " byte(10000000), " + RoomsContract.Columns.ROOM3_IMAGE + " byte(10000000), " + " FOREIGN KEY (" + RoomsContract.Columns.HOTEL_ROOM_ID + ") REFERENCES " + HotelContract.HOTEL_TABLE_NAME + "(" + HotelContract.Columns.HOTEL_ID + "))";
            db.execSQL(s2);
            String s3 = "CREATE TABLE " + GuestsContract.GUEST_TABLE_NAME + "(" + GuestsContract.Columns.GUEST_NAME + " TEXT, " + GuestsContract.Columns.GUEST_LOCATION + " TEXT, " + GuestsContract.Columns.GUEST_PHONE + " INTEGER, " + GuestsContract.Columns.GUEST_EMAIL + " TEXT, " + GuestsContract.Columns.GUEST_PASSWORD + " TEXT)";
            db.execSQL(s3);
            Log.d(TAG, "onCreate: ends");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HotelContract.HOTEL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RoomsContract.ROOM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GuestsContract.GUEST_TABLE_NAME);

        onCreate(db);
    }

    public boolean insertDataHotel(String HotelId, String HotelName, String HotelLocation,  String HotelContactPerson, String HotelContactNo, String StarRating, String HotelDescription, String HotelRoomType1, String HotelRoomType2, String HotelRoomType3, byte[] hotelpicture){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HotelContract.Columns.HOTEL_ID, HotelId);
        contentValues.put(HotelContract.Columns.HOTEL_NAME, HotelName);
        contentValues.put(HotelContract.Columns.HOTEL_LOCATION, HotelLocation);
        contentValues.put(HotelContract.Columns.HOTEL_CONTACT_PERSON, HotelContactPerson);
        contentValues.put(HotelContract.Columns.HOTEL_CONTACT_NUMBER, HotelContactNo);
        contentValues.put(HotelContract.Columns.HOTEL_STAR_RATING, StarRating);
        contentValues.put(HotelContract.Columns.HOTEL_DESCRIPTION, HotelDescription);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_1, HotelRoomType1);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_2, HotelRoomType2);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_3, HotelRoomType3);
        contentValues.put(HotelContract.Columns.HOTEL_IMAGES, hotelpicture);
        long result = db.insert(HotelContract.HOTEL_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataRoom(String RoomId, String RoomType1, String RoomType2, String RoomType3, String HotelRoomID, String ONoOfRooms, String Oprice , String ORoomDescription , String LNoOfRooms, String LPrice, String LRoomDescription, String SNoOfRooms, String SPrice, String SRoomDescription, byte[] Room1, byte[] Room2, byte[] Room3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RoomsContract.Columns.ROOM_ID, RoomId);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE1, RoomType1);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE2, RoomType2);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE3, RoomType3);
        contentValues.put(RoomsContract.Columns.HOTEL_ROOM_ID, HotelRoomID);
        contentValues.put(RoomsContract.Columns.O_NO_OF_ROOMS, ONoOfRooms);
        contentValues.put(RoomsContract.Columns.ORDINARY_ROOM_PRICE, Oprice);
        contentValues.put(RoomsContract.Columns.ORDINARY_ROOM_DESCRIPTION, ORoomDescription);
        contentValues.put(RoomsContract.Columns.L_NO_OF_ROOMS, LNoOfRooms);
        contentValues.put(RoomsContract.Columns.LUXURY_ROOM_PRICE, LPrice);
        contentValues.put(RoomsContract.Columns.LUXURY_ROOM_DESCRIPTION, LRoomDescription);
        contentValues.put(RoomsContract.Columns.S_NO_OF_ROOMS, SNoOfRooms);
        contentValues.put(RoomsContract.Columns.SUPERLUXURY_ROOM_PRICE, SPrice);
        contentValues.put(RoomsContract.Columns.SUPERLUXURY_ROOM_DESCRIPTION, SRoomDescription);
        contentValues.put(RoomsContract.Columns.ROOM1_IMAGE, Room1);
        contentValues.put(RoomsContract.Columns.ROOM2_IMAGE, Room2);
        contentValues.put(RoomsContract.Columns.ROOM3_IMAGE, Room3);
        long result = db.insert(RoomsContract.ROOM_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataGuest(String GuestName, String GuestLocation, String GuestPhone, String GuestEmail, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GuestsContract.Columns.GUEST_NAME, GuestName);
        contentValues.put(GuestsContract.Columns.GUEST_LOCATION, GuestLocation);
        contentValues.put(GuestsContract.Columns.GUEST_PHONE, GuestPhone);
        contentValues.put(GuestsContract.Columns.GUEST_EMAIL, GuestEmail);
        contentValues.put(GuestsContract.Columns.GUEST_PASSWORD, Password);
        long result = db.insert(GuestsContract.GUEST_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateHotelData(String HotelId, String HotelName, String HotelLocation, String HotelContactPerson, String HotelContactNo, String StarRating, String HotelDescription, String HotelRoomType1, String HotelRoomType2, String HotelRoomType3, byte[] hotelpicture){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HotelContract.Columns.HOTEL_ID, HotelId);
        contentValues.put(HotelContract.Columns.HOTEL_NAME, HotelName);
        contentValues.put(HotelContract.Columns.HOTEL_LOCATION, HotelLocation);
        contentValues.put(HotelContract.Columns.HOTEL_CONTACT_PERSON, HotelContactPerson);
        contentValues.put(HotelContract.Columns.HOTEL_CONTACT_NUMBER, HotelContactNo);
        contentValues.put(HotelContract.Columns.HOTEL_STAR_RATING, StarRating);
        contentValues.put(HotelContract.Columns.HOTEL_DESCRIPTION, HotelDescription);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_1, HotelRoomType1);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_2, HotelRoomType2);
        contentValues.put(HotelContract.Columns.HOTEL_ROOM_TYPE_3, HotelRoomType3);
        contentValues.put(HotelContract.Columns.HOTEL_IMAGES, hotelpicture);
        db.update(HotelContract.HOTEL_TABLE_NAME, contentValues, HotelContract.Columns.HOTEL_ID + "= ?", new String[] { HotelId });
        return true;
    }

    public boolean updateRoomData(String RoomId, String RoomType1, String RoomType2, String RoomType3, String HotelRoomID, String ONoOfRooms, String Oprice, String ORoomDescription, String LNoOfRooms, String LPrice, String LRoomDescription, String SNoOfRooms, String SPrice, String SRoomDescription, byte[] Room1, byte[] Room2, byte[] Room3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RoomsContract.Columns.ROOM_ID, RoomId);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE1, RoomType1);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE2, RoomType2);
        contentValues.put(RoomsContract.Columns.ROOM_TYPE3, RoomType3);
        contentValues.put(RoomsContract.Columns.HOTEL_ROOM_ID, HotelRoomID);
        contentValues.put(RoomsContract.Columns.O_NO_OF_ROOMS, ONoOfRooms);
        contentValues.put(RoomsContract.Columns.ORDINARY_ROOM_PRICE, Oprice);
        contentValues.put(RoomsContract.Columns.ORDINARY_ROOM_DESCRIPTION, ORoomDescription);
        contentValues.put(RoomsContract.Columns.L_NO_OF_ROOMS, LNoOfRooms);
        contentValues.put(RoomsContract.Columns.LUXURY_ROOM_PRICE, LPrice);
        contentValues.put(RoomsContract.Columns.LUXURY_ROOM_DESCRIPTION, LRoomDescription);
        contentValues.put(RoomsContract.Columns.S_NO_OF_ROOMS, SNoOfRooms);
        contentValues.put(RoomsContract.Columns.SUPERLUXURY_ROOM_PRICE, SPrice);
        contentValues.put(RoomsContract.Columns.SUPERLUXURY_ROOM_DESCRIPTION, SRoomDescription);
        contentValues.put(RoomsContract.Columns.ROOM1_IMAGE, Room1);
        contentValues.put(RoomsContract.Columns.ROOM2_IMAGE, Room2);
        contentValues.put(RoomsContract.Columns.ROOM3_IMAGE, Room3);
        db.update(RoomsContract.ROOM_TABLE_NAME, contentValues, RoomsContract.Columns.HOTEL_ROOM_ID + "= ?", new String[] { HotelRoomID });
        return true;
    }

    public int deleteHotelData(String HotelId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HotelContract.HOTEL_TABLE_NAME, HotelContract.Columns.HOTEL_ID + "= ?", new String[] {HotelId});
    }

    public int deleteRoomData(String HotelRoomId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(RoomsContract.ROOM_TABLE_NAME, RoomsContract.Columns.HOTEL_ROOM_ID + "= ?", new String[] {HotelRoomId});
    }

    public Cursor getGuestData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + GuestsContract.GUEST_TABLE_NAME, null);
        return cursor;
    }

    public Cursor getHotelData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + HotelContract.HOTEL_TABLE_NAME, null);
        return cursor;
    }
    public Cursor getRoomData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + RoomsContract.ROOM_TABLE_NAME , null);
        return cursor;
    }

}
