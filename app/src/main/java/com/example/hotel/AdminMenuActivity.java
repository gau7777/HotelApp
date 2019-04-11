package com.example.hotel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminMenuActivity extends AppCompatActivity implements View.OnClickListener{
      Button hotels;
      Button rooms;
    Intent intent = null;
    AppDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        hotels = (Button) findViewById(R.id.Hotels_Button);
        rooms = (Button) findViewById(R.id.Rooms_Button);
        mydb = new AppDatabase(this);


        hotels.setOnClickListener(this);
        rooms.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.Hotels_Button:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Choose the task");
                builder1.setPositiveButton("Add Hotels", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(AdminMenuActivity.this, HotelDetailsActivity.class);
                        startActivity(intent);
                    }
                });
                builder1.setNegativeButton("Modify Hotels", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(AdminMenuActivity.this, AdminHotelListActivity.class);
                        startActivity(intent);
                    }
                });
                builder1.setNeutralButton("Delete Hotels", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View view = getLayoutInflater().inflate(R.layout.delete_hotel, null);
                        final EditText editText = (EditText) view.findViewById(R.id.del_hotel);
                      AlertDialog.Builder builder = new AlertDialog.Builder(AdminMenuActivity.this);
                      builder.setTitle("Delete Hotel");
                      builder.setMessage("Enter ID of Hotel");
                      builder.setView(view);
                      builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              String delHId = editText.getText().toString();
                              int delete = mydb.deleteHotelData(delHId);
                        if (delete > 0) {
                            Toast.makeText(AdminMenuActivity.this, "Hotel Data Deleted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(AdminMenuActivity.this, "Hotel Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                          }
                      });
                      builder.show();
                    }
                });
                builder1.show();

                  break;

            case R.id.Rooms_Button:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose the task");
                builder2.setPositiveButton("Add Rooms", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(AdminMenuActivity.this, RoomsDetailsActivity.class);
                        startActivity(intent);
                    }
                });
                builder2.setNegativeButton("Modify Rooms", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(AdminMenuActivity.this, AdminRoomListActivity.class);
                        startActivity(intent);
                    }
                });
                builder2.setNeutralButton("Delete Rooms", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View view = getLayoutInflater().inflate(R.layout.delete_room, null);
                        final EditText editText = (EditText) view.findViewById(R.id.del_Room);
                        AlertDialog.Builder builder = new AlertDialog.Builder(AdminMenuActivity.this);
                        builder.setTitle("Delete Room");
                        builder.setMessage("Enter ID of Room");
                        builder.setView(view);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String delHId = editText.getText().toString();
                                int delete = mydb.deleteRoomData(delHId);
                                if (delete > 0) {
                                    Toast.makeText(AdminMenuActivity.this, "Room Data Deleted", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(AdminMenuActivity.this, "Room Data not Deleted", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                        builder.show();
                    }
                });
                builder2.show();
                break;
            default:
        }
    }
}
