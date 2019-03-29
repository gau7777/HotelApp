package com.example.hotel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenuActivity extends AppCompatActivity implements View.OnClickListener{
      Button hotels;
      Button rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        hotels = (Button) findViewById(R.id.Hotels_Button);
        rooms = (Button) findViewById(R.id.Rooms_Button);


        hotels.setOnClickListener(this);
        rooms.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.Hotels_Button:
                  intent = new Intent(this, HotelDetailsActivity.class);
                  break;

            case R.id.Rooms_Button:
                   intent = new Intent(this, RoomsDetailsActivity.class);
                   break;

            default:
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
