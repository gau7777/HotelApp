package com.example.hotel;

import android.content.ContentUris;
import android.net.Uri;

public class RoomsContract {

    public static final String ROOM_TABLE_NAME = "RoomTable";

    //Hotel Fields
    public static class Columns{
        public static final String ROOM_ID = "RoomId";
        public static final String ROOM_TYPE1 = "RoomType1";
        public static final String ROOM_TYPE2 = "RoomType2";
        public static final String ROOM_TYPE3 = "RoomType3";
        public static final String HOTEL_ROOM_ID = "HotelRoomId";
        public static final String O_NO_OF_ROOMS = "NoOfRooms_Ordinary";
        public static final String L_NO_OF_ROOMS = "NoOfRooms_Luxury";
        public static final String S_NO_OF_ROOMS = "NoOfRooms_SuperLuxury";
        public static final String ORDINARY_ROOM_PRICE = "OrdinaryPrice";
        public static final String LUXURY_ROOM_PRICE = "LuxuryPrice";
        public static final String SUPERLUXURY_ROOM_PRICE = "SuperLuxuryPrice";
        public static final String ORDINARY_ROOM_DESCRIPTION = "OrdinaryDescription";
        public static final String LUXURY_ROOM_DESCRIPTION = "LuxuryDescription";
        public static final String SUPERLUXURY_ROOM_DESCRIPTION = "SuperLuxuryDescription";
        public static final String ROOM1_IMAGE = "Room1_image";
        public static final String ROOM2_IMAGE = "Room2_image";
        public static final String ROOM3_IMAGE = "Room3_image";

        private Columns(){
            //private constructor to prevent instantiation.
        }
    }
}
