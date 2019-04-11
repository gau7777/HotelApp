package com.example.hotel;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class HotelContract {

    public static final String HOTEL_TABLE_NAME = "hotelTable";

    //Hotel Fields
    public static class Columns{
        public static final String HOTEL_ID = BaseColumns._ID;
        public static final String HOTEL_NAME = "Name";
        public static final String HOTEL_LOCATION = "Location";
        public static final String HOTEL_CONTACT_PERSON = "Contact_Person";
        public static final String HOTEL_CONTACT_NUMBER = "Contact_No";
        public static final String HOTEL_STAR_RATING = "Star_Rating";
        public static final String HOTEL_DESCRIPTION = "Description";
        public static final String HOTEL_ROOM_TYPE_1 = "RoomType1";
        public static final String HOTEL_ROOM_TYPE_2 = "RoomType2";
        public static final String HOTEL_ROOM_TYPE_3 = "RoomType3";
        public static final String HOTEL_IMAGES = "Image";

        private Columns(){
            //private constructor to prevent instantiation.
        }
    }

    static final String CONTENT_AUTHORITY = "com.example.hotel.provider";
    public static final Uri CONTENT_AUTHORITY_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, HOTEL_TABLE_NAME); // URI to access the Tasks table.
//
//    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + HOTEL_TABLE_NAME;
//    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + HOTEL_TABLE_NAME;
//
//    static Uri buildTaskUri(long taskId){
//        return ContentUris.withAppendedId(CONTENT_URI, taskId);
//    }
//
//    static long getTaskId(Uri uri){
//        return ContentUris.parseId(uri);
//    }
}

