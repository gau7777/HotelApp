package com.example.hotel;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RoomsDetailsActivity extends AppCompatActivity implements View.OnClickListener{
         Button submitRoomDetails;
         EditText roomType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_details);

        submitRoomDetails = (Button) findViewById(R.id.room_details_save_button);
        roomType = (EditText) findViewById(R.id.hotel_room_id_box);
        submitRoomDetails.setOnClickListener(this);
        roomType.setClickable(true);
        roomType.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.room_details_save_button:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Choose from options");
                builder1.setNeutralButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder1.setPositiveButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder1.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder1.show();
                break;
            case R.id.room_type_box:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose from options");
                builder2.setNeutralButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder2.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder2.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder2.show();
            default:
        }

    }

}
