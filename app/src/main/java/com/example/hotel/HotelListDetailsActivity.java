package com.example.hotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelListDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView TextHotelName;
    TextView TextHotelLocation;
    TextView TextHotelContactPerson;
    TextView TextHotelContactNo;
    TextView TextHotelStarRating;
    TextView TextHotelDescription;
    ImageView HImage;
    Button roomDetails;
    String HName, HLocation, HContactPerson, HDescription;
    int HContactNo, HRating, pos;
    byte[] Hphoto;
    AppDatabase mydb;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list_details);

        TextHotelName = (TextView) findViewById(R.id.showHotelName);
        TextHotelLocation = (TextView) findViewById(R.id.showHotelLocation);
        TextHotelContactPerson = (TextView) findViewById(R.id.showContactPerson);
        TextHotelContactNo = (TextView) findViewById(R.id.showContactNumber);
        TextHotelStarRating = (TextView) findViewById(R.id.showStarRating);
        TextHotelDescription = (TextView) findViewById(R.id.showDescription);
        HImage = (ImageView) findViewById(R.id.setHotelimageView);
        roomDetails = (Button) findViewById(R.id.RoomsButton);

        mydb = new AppDatabase(this);


        Intent intent = getIntent();
        if (intent != null) {
            HName = intent.getStringExtra("Name");
            HLocation = intent.getStringExtra("Location");
            HContactPerson = intent.getStringExtra("ContactPerson");
            HContactNo = intent.getIntExtra("ContactNumber", 0);
            HRating = intent.getIntExtra("StarRating", 0);
            HDescription = intent.getStringExtra("Description");
            Hphoto = intent.getByteArrayExtra("HotelImage");
        }

        pos = intent.getIntExtra("Position", 0);

        TextHotelName.setText(HName);
        TextHotelLocation.setText("Location = " + HLocation);
        TextHotelContactPerson.setText("Contact Person = " + HContactPerson);
        TextHotelContactNo.setText("Contact Number = " + HContactNo);
        TextHotelStarRating.setText("Star Rating = " + HRating + "/5");
        TextHotelDescription.setText("Description = " + HDescription);
        HImage.setImageBitmap(convertToBitmap(Hphoto));

        roomDetails.setOnClickListener(this);

    }

    private Bitmap convertToBitmap(byte[] b) {
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }

    @Override
    public void onClick(View v) {
        Cursor res = mydb.getRoomData();
            res.moveToPosition(pos);

            Intent intent = new Intent(HotelListDetailsActivity.this, HotelRoomDetailActivity.class);
            intent.putExtra("Type1", res.getString(1));
            intent.putExtra("Type2", res.getString(2));
            intent.putExtra("Type3", res.getString(3));
            intent.putExtra("No1", res.getInt(5));
            intent.putExtra("No2", res.getInt(8));
            intent.putExtra("No3", res.getInt(11));
            intent.putExtra("Des1", res.getString(7));
            intent.putExtra("Des2", res.getString(10));
            intent.putExtra("Des3", res.getString(13));
            intent.putExtra("Price1", res.getInt(6));
            intent.putExtra("Price2", res.getInt(9));
            intent.putExtra("Price3", res.getInt(12));
            intent.putExtra("Image1", res.getBlob(14));
            intent.putExtra("Image2", res.getBlob(15));
            intent.putExtra("Image3", res.getBlob(16));
            startActivity(intent);


    }

}
