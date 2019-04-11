package com.example.hotel;

import java.util.Arrays;

public class Rooms {
    public static final long SerialVersionUID = 20190322L;

    private long m_RoomId;
    private String m_RoomType1;
    private String m_RoomType2;
    private String m_RoomType3;
    private long m_HotelRoomId;
    private int m_NoOfRooms;
    private int m_RoomPrice;
    private String m_RoomDescription;
    private String m_RoomFacilities;
    private byte[] hImage1, hImage2, hImage3;

    public Rooms(long m_RoomId, String m_RoomType1, String m_RoomType2, String m_RoomType3, long m_HotelRoomId, int m_NoOfRooms, int m_RoomPrice, String m_RoomDescription, String m_RoomFacilities, byte[] hImage1, byte[] hImage2, byte[] hImage3) {
        this.m_RoomId = m_RoomId;
        this.m_RoomType1 = m_RoomType1;
        this.m_RoomType2 = m_RoomType2;
        this.m_RoomType3 = m_RoomType3;
        this.m_HotelRoomId = m_HotelRoomId;
        this.m_NoOfRooms = m_NoOfRooms;
        this.m_RoomPrice = m_RoomPrice;
        this.m_RoomDescription = m_RoomDescription;
        this.m_RoomFacilities = m_RoomFacilities;
        this.hImage1 = hImage1;
        this.hImage2 = hImage2;
        this.hImage3 = hImage3;
    }

    public long getRoomId() {
        return m_RoomId;
    }

    public String getRoomType1() {
        return m_RoomType1;
    }

    public String getM_RoomType2() {
        return m_RoomType2;
    }

    public String getM_RoomType3() {
        return m_RoomType3;
    }

    public long getHotelRoomId() {
        return m_HotelRoomId;
    }

    public int getNoOfRooms() {
        return m_NoOfRooms;
    }

    public int getRoomPrice() {
        return m_RoomPrice;
    }

    public String getRoomDescription() {
        return m_RoomDescription;
    }

    public String getRoomFacilities() {
        return m_RoomFacilities;
    }

    public void setRoomId(long m_RoomId) {
        this.m_RoomId = m_RoomId;
    }

    public void setHotelRoomId(long m_HotelRoomId) {
        this.m_HotelRoomId = m_HotelRoomId;
    }

    public void setRoomType1(String m_RoomType) {
        this.m_RoomType1 = m_RoomType1;
    }

    public void setM_RoomType2(String m_RoomType2) {
        this.m_RoomType2 = m_RoomType2;
    }

    public void setM_RoomType3(String m_RoomType3) {
        this.m_RoomType3 = m_RoomType3;
    }

    public void setNoOfRooms(int m_NoOfRooms) {
        this.m_NoOfRooms = m_NoOfRooms;
    }

    public void setRoomPrice(int m_RoomPrice) {
        this.m_RoomPrice = m_RoomPrice;
    }

    public void setRoomDescription(String m_RoomDescription) {
        this.m_RoomDescription = m_RoomDescription;
    }

    public void setRoomFacilities(String m_RoomFacilities) {
        this.m_RoomFacilities = m_RoomFacilities;
    }

    public byte[] gethImage1() {
        return hImage1;
    }

    public byte[] gethImage2() {
        return hImage2;
    }

    public byte[] gethImage3() {
        return hImage3;
    }

    public void sethImage1(byte[] hImage1) {
        this.hImage1 = hImage1;
    }

    public void sethImage2(byte[] hImage2) {
        this.hImage2 = hImage2;
    }

    public void sethImage3(byte[] hImage3) {
        this.hImage3 = hImage3;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "m_RoomId=" + m_RoomId +
                ", m_RoomType1='" + m_RoomType1 + '\'' +
                ", m_RoomType2='" + m_RoomType2 + '\'' +
                ", m_RoomType3='" + m_RoomType3 + '\'' +
                ", m_HotelRoomId=" + m_HotelRoomId +
                ", m_NoOfRooms=" + m_NoOfRooms +
                ", m_RoomPrice=" + m_RoomPrice +
                ", m_RoomDescription='" + m_RoomDescription + '\'' +
                ", m_RoomFacilities='" + m_RoomFacilities + '\'' +
                ", hImage1=" + Arrays.toString(hImage1) +
                ", hImage2=" + Arrays.toString(hImage2) +
                ", hImage3=" + Arrays.toString(hImage3) +
                '}';
    }
}
