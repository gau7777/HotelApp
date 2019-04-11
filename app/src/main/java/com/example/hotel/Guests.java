package com.example.hotel;

import java.io.Serializable;

public class Guests implements Serializable {
    public static final long SerialVersionUID = 20190322L;

    private String m_GuestName;
    private String m_GuestLocation;
    private String m_GuestPhone;
    private String m_GuestEmail;
    private String m_GuestPassword;

    public Guests(String m_GuestName, String m_GuestLocation, String m_GuestPhone, String m_GuestEmail, String m_GuestPassword) {
        this.m_GuestName = m_GuestName;
        this.m_GuestLocation = m_GuestLocation;
        this.m_GuestPhone = m_GuestPhone;
        this.m_GuestEmail = m_GuestEmail;
        this.m_GuestPassword = m_GuestPassword;
    }

    public String getGuestName() {
        return m_GuestName;
    }

    public String getGuestLocation() {
        return m_GuestLocation;
    }

    public String getGuestPhone() {
        return m_GuestPhone;
    }

    public String getGuestEmail() {
        return m_GuestEmail;
    }

    public String getGuestPassword() {
        return m_GuestPassword;
    }

    public void setGuestName(String m_GuestName) {
        this.m_GuestName = m_GuestName;
    }

    public void setGuestLocation(String m_GuestLocation) {
        this.m_GuestLocation = m_GuestLocation;
    }

    public void setGuestPhone(String m_GuestPhone) {
        this.m_GuestPhone = m_GuestPhone;
    }

    public void setGuestEmail(String m_GuestEmail) {
        this.m_GuestEmail = m_GuestEmail;
    }

    public void setGuestPassword(String m_GuestPassword) {
        this.m_GuestPassword = m_GuestPassword;
    }

    @Override
    public String toString() {
        return "Guests{" +
                "m_GuestName='" + m_GuestName + '\'' +
                ", m_GuestLocation='" + m_GuestLocation + '\'' +
                ", m_GuestPhone='" + m_GuestPhone + '\'' +
                ", m_GuestEmail='" + m_GuestEmail + '\'' +
                ", m_GuestPassword='" + m_GuestPassword + '\'' +
                '}';
    }
}
