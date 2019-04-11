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

public class AdminRoomListActivity extends AppCompatActivity {
AppDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_room_list);

        ListView RoomListView = (ListView) findViewById(R.id.Admin_Room_id_listview);
        mydb = new AppDatabase(this);

        ArrayList<String> RoomList = new ArrayList<>();

        Cursor cursor = mydb.getRoomData();

        if(cursor.getCount() == 0){
            Toast.makeText(AdminRoomListActivity.this, "Empty Hotel List", Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                RoomList.add(cursor.getString(4));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RoomList);
                RoomListView.setAdapter(listAdapter);
            }
        }

        RoomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor res = mydb.getRoomData();
                res.moveToPosition(position);
                Intent intent = new Intent(AdminRoomListActivity.this, RoomAdminView.class);
                intent.putExtra("Rid", res.getInt(0));
                intent.putExtra("Type1", res.getString(1));
                intent.putExtra("Type2", res.getString(2));
                intent.putExtra("Type3", res.getString(3));
                intent.putExtra("HRid", res.getInt(4));
                intent.putExtra("ONoR", res.getInt(5));
                intent.putExtra("ORPr", res.getInt(6));
                intent.putExtra("ORDes", res.getString(7));
                intent.putExtra("LNoR", res.getInt(8));
                intent.putExtra("LRPr", res.getInt(9));
                intent.putExtra("LRDes", res.getString(10));
                intent.putExtra("SNoR", res.getInt(11));
                intent.putExtra("SRPr", res.getInt(12));
                intent.putExtra("SRDes", res.getString(13));
                intent.putExtra("RImage1", res.getBlob(14));
                intent.putExtra("RImage2", res.getBlob(15));
                intent.putExtra("RImage3", res.getBlob(16));
                startActivity(intent);
            }
        });

    }
}
