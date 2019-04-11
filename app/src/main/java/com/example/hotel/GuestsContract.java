package com.example.hotel;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class GuestsContract {

    public static final String GUEST_TABLE_NAME = "GuestTable";

    //Hotel Fields
    public static class Columns{
        public static final String GUEST_NAME = "Name";
        public static final String GUEST_LOCATION = "Address";
        public static final String GUEST_PHONE = "PhoneNo";
        public static final String GUEST_EMAIL = "EMAIL_ID";
        public static final String GUEST_PASSWORD = "Password";

        private Columns(){
            //private constructor to prevent instantiation.
        }
    }

//    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, GUEST_TABLE_NAME); // URI to access the Tasks table.
//
//    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + GUEST_TABLE_NAME;
//    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + GUEST_TABLE_NAME;
//
//    static Uri buildTaskUri(long taskId){
//        return ContentUris.withAppendedId(CONTENT_URI, taskId);
//    }
//
//    static long getTaskId(Uri uri){
//        return ContentUris.parseId(uri);
//    }
}
