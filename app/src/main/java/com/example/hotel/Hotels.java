package com.example.hotel;
import android.net.Uri;

import java.io.Serializable;
import java.sql.Blob;

class Hotels implements Serializable {
    public static final long SerialVersionUID = 20190322L;

    private long m_Hotelid;
    private final String mHotelName;
    private final String mHotelCity;
    private final String mHotelContactPerson;
    private final int  mHotelContactNo;
    private final int mHotelRating;
    private final String mHotelDescription;
    private final String mHotelRoom1;
    private final String mHotelRoom2;
    private final String mHotelRoom3;
    private byte[] hotelimage;


    public Hotels(long m_Hotelid, String mHotelName, String mHotelCity, String mHotelContactPerson, int mHotelContactNo, int mHotelRating, String mHotelDescription, String mHotelRoom1, String mHotelRoom2, String mHotelRoom3, byte[] hotelimage) {
        this.m_Hotelid = m_Hotelid;
        this.mHotelName = mHotelName;
        this.mHotelCity = mHotelCity;
        this.mHotelContactPerson = mHotelContactPerson;
        this.mHotelContactNo = mHotelContactNo;
        this.mHotelRating = mHotelRating;
        this.mHotelDescription = mHotelDescription;
        this.mHotelRoom1 = mHotelRoom1;
        this.mHotelRoom2 = mHotelRoom2;
        this.mHotelRoom3 = mHotelRoom3;
        this.hotelimage = hotelimage;
    }

    public long getHotelId() {
        return m_Hotelid;
    }

    public String getHotelName() {
        return mHotelName;
    }

    public String getHotelCity() {
        return mHotelCity;
    }

    public String getHotelContactPerson() {
        return mHotelContactPerson;
    }

    public int getHotelContactNo() {
        return mHotelContactNo;
    }

    public int getHotelRating() {
        return mHotelRating;
    }

    public String getHotelDescription() {
        return mHotelDescription;
    }

    public String getHotelRoom1() {
        return mHotelRoom1;
    }

    public String getmHotelRoom2() {
        return mHotelRoom2;
    }

    public String getmHotelRoom3() {
        return mHotelRoom3;
    }

    public byte[] getHotelimage() {
        return hotelimage;
    }

    public void setHotelid(long m_Hotelid) {
        this.m_Hotelid = m_Hotelid;
    }

    public void setM_Hotelid(long m_Hotelid) {
        this.m_Hotelid = m_Hotelid;
    }

    public void setHotelimage(byte[] b){
        this.hotelimage = b;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "m_Hotelid=" + m_Hotelid +
                ", mHotelName='" + mHotelName + '\'' +
                ", mHotelCity='" + mHotelCity + '\'' +
                ", mHotelContactPerson='" + mHotelContactPerson + '\'' +
                ", mHotelContactNo=" + mHotelContactNo +
                ", mHotelRating=" + mHotelRating +
                ", mHotelDescription='" + mHotelDescription + '\'' +
                ", mHotelRoom1='" + mHotelRoom1 + '\'' +
                ", mHotelRoom2='" + mHotelRoom2 + '\'' +
                ", mHotelRoom3='" + mHotelRoom3 + '\'' +
                '}';
    }
}