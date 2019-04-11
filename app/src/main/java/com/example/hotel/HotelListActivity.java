package com.example.hotel;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HotelListActivity extends AppCompatActivity {

    AppDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        ListView HotelListView = (ListView) findViewById(R.id.Hotel_name_listview);
        mydb = new AppDatabase(this);

        ArrayList<String> HotelList = new ArrayList<>();

        Cursor cursor = mydb.getHotelData();

        if(cursor.getCount() == 0){
            Toast.makeText(HotelListActivity.this, "Empty Hotel List", Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                HotelList.add(cursor.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HotelList);
                HotelListView.setAdapter(listAdapter);
            }
        }

      HotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Cursor res = mydb.getHotelData();
              res.moveToPosition(position);
              Intent intent = new Intent(HotelListActivity.this, HotelListDetailsActivity.class);
              intent.putExtra("Position", position);
              intent.putExtra("Name", res.getString(1));
              intent.putExtra("Location", res.getString(2));
              intent.putExtra("ContactPerson", res.getString(3));
              intent.putExtra("ContactNumber", res.getInt(4));
              intent.putExtra("StarRating", res.getInt(5));
              intent.putExtra("Description", res.getString(6));
              intent.putExtra("HotelImage", res.getBlob(10));
              startActivity(intent);


          }
      });
    }
}
