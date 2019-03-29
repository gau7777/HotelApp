package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Hotel_App_Data.db";
    public static final String HOTEL_TABLE_NAME = "hotel_table";
    public static final String ROOM_TABLE_NAME = "room_table";
    public static final String GUEST_TABLE_NAME = "guest_table";
    public static final String GUEST_LOGIN_TABLE_NAME = "guest_login_table";
    public static final String ADMIN_LOGIN_TABLE_NAME = "admin_table";

    // Columns of hotel table
    public static final String HOTEL_ID = "Hotel_ID";
    public static final String HOTEL_NAME = "Name";
    public static final String HOTEL_LOCATION = "Location";
    public static final String HOTEL_CONTACT_PERSON = "Contact_Person";
    public static final String HOTEL_CONTACT_NUMBER = "Contact_No.";
    public static final String HOTEL_STAR_RATING = "Star_Rating";
    public static final String HOTEL_DESCRIPTION = "Description";
    public static final String HOTEL_IMAGES = "Image";

    //Columns of room table
    public static final String ROOM_ID = "Room_ID";
    public static final String ROOM_TYPE = "Room_Type";
    public static final String HOTEL_ROOM_ID= "HotelRoomID";
    public static final String NO_OF_ROOMS = "No_Of_Rooms";
    public static final String ROOM_PRICE_ = "Price";
    public static final String ROOM_DESCRIPTION = "Description";
    public static final String ROOM_IMAGES = "Image";

    //Columns of guest table
    public static final String GUEST_NAME = "Name";
    public static final String GUEST_LOCATION = "Address";
    public static final String GUEST_PHONE = "Phone_No.";
    public static final String GUEST_EMAIL = "Email_ID";
    public static final String GUEST_PASSWORD = "Password";

    public AppDatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE " + HOTEL_TABLE_NAME + "(HOTEL_ID INTEGER PRIMARY KEY AUTOINCREMENT, HOTEL_NAME TEXT, HOTEL_LOCATION TEXT, HOTEL_CONTACT_PERSON TEXT, HOTEL_CONTACT_NUMBER INTEGER, HOTEL_STAR_RATING INTEGER, HOTEL_DESCRIPTION TEXT)");
         db.execSQL("CREATE TABLE " + ROOM_TABLE_NAME + "(ROOM_ID INTEGER PRIMARY KEY AUTOINCREMENT, ROOM_TYPE TEXT, HOTEL_ROOM_ID INTEGER, NO_OF_ROOMS INTEGER, ROOM_PRICE INTEGER, ROOM_DESCRIPTION TEXT, FOREIGN KEY (HOTEL_ROOM_ID) REFERENCES HOTEL_TABLE_NAME(HOTEL_ID))");
         db.execSQL("CREATE TABLE " + GUEST_TABLE_NAME + "(GUEST_NAME TEXT, GUEST_LOCATION TEXT, GUEST_PHONE INTEGER, GUEST_EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS " + HOTEL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ROOM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GUEST_TABLE_NAME);

        onCreate(db);
    }

    public boolean insertDataHotel(String HotelName, String HotelLocation, String HotelContactPerson, int HotelContactNo, int StarRating, String HotelDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOTEL_NAME, HotelName);
        contentValues.put(HOTEL_LOCATION, HotelLocation);
        contentValues.put(HOTEL_CONTACT_PERSON, HotelContactPerson);
        contentValues.put(HOTEL_CONTACT_NUMBER, HotelContactNo);
        contentValues.put(HOTEL_STAR_RATING, StarRating);
        contentValues.put(HOTEL_DESCRIPTION, HotelDescription);
        long result = db.insert(HOTEL_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataRoom(String RoomType, String HotelRoomID, int NoOfRooms, int price, String RoomDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROOM_TYPE, RoomType);
        contentValues.put(HOTEL_ROOM_ID, HotelRoomID);
        contentValues.put(NO_OF_ROOMS, NoOfRooms);
        contentValues.put(ROOM_PRICE_, price);
        contentValues.put(ROOM_DESCRIPTION, RoomDescription);
        long result = db.insert(ROOM_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataGuest(String GuestName, int GuestLocation, int GuestPhone, String GuestEmail, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GUEST_NAME, GuestName);
        contentValues.put(GUEST_LOCATION, GuestLocation);
        contentValues.put(GUEST_PHONE, GuestPhone);
        contentValues.put(GUEST_EMAIL, GuestEmail);
        contentValues.put(GUEST_PASSWORD, Password);
        long result = db.insert(GUEST_TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateHotelData(String HotelId, String HotelName, String HotelLocation, String HotelContactPerson, int HotelContactNo, int StarRating, String HotelDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOTEL_ID, HotelId);
        contentValues.put(HOTEL_NAME, HotelName);
        contentValues.put(HOTEL_LOCATION, HotelLocation);
        contentValues.put(HOTEL_CONTACT_PERSON, HotelContactPerson);
        contentValues.put(HOTEL_CONTACT_NUMBER, HotelContactNo);
        contentValues.put(HOTEL_STAR_RATING, StarRating);
        contentValues.put(HOTEL_DESCRIPTION, HotelDescription);
        db.update(HOTEL_TABLE_NAME, contentValues, "HOTEL_ID = ?", new String[] { HotelId });
        return true;
    }

    public boolean updateRoomData(String RoomId, String RoomType, String HotelRoomId, int NoOfRooms, int price, String RoomDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROOM_ID, RoomId);
        contentValues.put(ROOM_TYPE, RoomType);
        contentValues.put(HOTEL_ROOM_ID, HotelRoomId);
        contentValues.put(NO_OF_ROOMS, NoOfRooms);
        contentValues.put(ROOM_PRICE_, price);
        contentValues.put(ROOM_DESCRIPTION, RoomDescription);
        db.update(HOTEL_TABLE_NAME, contentValues, "HOTEL_ROOM_ID = ?", new String[] { HotelRoomId });
        return true;
    }

    public int deleteHotelData(String HotelId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(HOTEL_TABLE_NAME, "HOTEL_ID = ?", new String[] {HotelId});
    }

    public int deleteRoomData(String HotelRoomId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ROOM_TABLE_NAME, "HOTEL_ROOM_ID = ?", new String[] {HotelRoomId});
    }

}
