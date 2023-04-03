package com.example.prm_he151521_daophucthach;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class guest {
   public int GuestId;
   public String GuestName;
   public String GuestBirth;
   public String GuestGender;
   public String GuestMobile;

   public void guest(){

   }

    public guest(int guestId, String guestName, String guestBirth, String guestGender, String guestMobile) {
        GuestId = guestId;
        GuestName = guestName;
        GuestBirth = guestBirth;
        GuestGender = guestGender;
        GuestMobile = guestMobile;
    }

    public int getGuestId() {
        return GuestId;
    }

    public void setGuestId(int guestId) {
        GuestId = guestId;
    }

    public String getGuestName() {
        return GuestName;
    }

    public void setGuestName(String guestName) {
        GuestName = guestName;
    }

    public String getGuestBirth() {
        return GuestBirth;
    }

    public void setGuestBirth(String guestBirth) {
        GuestBirth = guestBirth;
    }

    public String getGuestGender() {
        return GuestGender;
    }

    public void setGuestGender(String guestGender) {
        GuestGender = guestGender;
    }

    public String getGuestMobile() {
        return GuestMobile;
    }

    public void setGuestMobile(String guestMobile) {
        GuestMobile = guestMobile;
    }
}
