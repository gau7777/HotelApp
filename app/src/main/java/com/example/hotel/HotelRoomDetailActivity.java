package com.example.hotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelRoomDetailActivity extends AppCompatActivity {
    TextView type1, type2, type3, ONo, LNo, SNo, ODes, SDes, LDes, OPr, SPr, LPr;
    ImageView OImg, LImg, SImg;
    AppDatabase mydb;
    String Rtype1, Rtype2, Rtype3, RODes, RLDes, RSDes;
    int ROPr, RLPr, RSPr, RONo, RLNo, RSNo;
    byte[] type1pic, type2pic, type3pic;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_room_detail);

        type1 = (TextView) findViewById(R.id.Room1);
        type2 = (TextView) findViewById(R.id.Room2);
        type3 = (TextView) findViewById(R.id.Room3);
        ONo = (TextView) findViewById(R.id.type1No);
        LNo = (TextView) findViewById(R.id.type2No);
        SNo = (TextView) findViewById(R.id.type3No);
        ODes = (TextView) findViewById(R.id.type1Description);
        LDes = (TextView) findViewById(R.id.type2Description);
        SDes = (TextView) findViewById(R.id.type3Description);
        OPr = (TextView) findViewById(R.id.type1Price);
        LPr = (TextView) findViewById(R.id.type2Price);
        SPr = (TextView) findViewById(R.id.type3Price);
        OImg = (ImageView) findViewById(R.id.Type1imageView);
        LImg = (ImageView) findViewById(R.id.Type2imageView);
        SImg = (ImageView) findViewById(R.id.type3imageView);
        mydb = new AppDatabase(this);

        Intent intent = getIntent();
        if(intent != null){
            Rtype1 = intent.getStringExtra("Type1");
            Rtype2 = intent.getStringExtra("Type2");
            Rtype3 = intent.getStringExtra("Type3");
            RODes = intent.getStringExtra("Des1");
            RLDes = intent.getStringExtra("Des2");
            RSDes = intent.getStringExtra("Des3");
            ROPr = intent.getIntExtra("Price1", 0);
            RLPr = intent.getIntExtra("Price2", 0);
            RSPr = intent.getIntExtra("Price3", 0);
            RONo = intent.getIntExtra("No1", 0);
            RLNo = intent.getIntExtra("No2", 0);
            RSNo = intent.getIntExtra("No3", 0);
            type1pic = intent.getByteArrayExtra("Image1");
            type2pic = intent.getByteArrayExtra("Image2");
            type3pic = intent.getByteArrayExtra("Image3");
        }

        type1.setText(Rtype1);
        type2.setText(Rtype2);
        type3.setText(Rtype3);
        ODes.setText("Description :" + RODes);
        LDes.setText("Description :" + RLDes);
        SDes.setText("Description :" + RSDes);
        OPr.setText("Price per Day : =" + ROPr);
        LPr.setText("Price per Day : =" + RLPr);
        SPr.setText("Price per Day : =" + RSPr);
        ONo.setText("No. Of Rooms = " + RONo);
        LNo.setText("No. Of Rooms = " + RLNo);
        SNo.setText("No. Of Rooms = " + RSNo);
        OImg.setImageBitmap(convertToBitmap(type1pic));
        LImg.setImageBitmap(convertToBitmap(type2pic));
        SImg.setImageBitmap(convertToBitmap(type3pic));
    }

    private Bitmap convertToBitmap(byte[] b){
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }
}
