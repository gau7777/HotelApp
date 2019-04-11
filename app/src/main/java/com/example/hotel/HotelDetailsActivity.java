package com.example.hotel;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class HotelDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Button submitHotelDetails;
    TextView imagepath;
    Button roomType1Button;
    Button roomType2Button;
    Button roomType3Button;
    String[] split;
    public static final int RESULT_LOAD_IMAGE = 1;
    EditText hotelId;
    EditText hotalName;
    EditText hotelCity;
    EditText contactPerson;
    EditText contactNo;
    EditText starRating;
    EditText Description;
    EditText rt1_Editext;
    EditText rt2_EditText;
    EditText rt3_EditText;
    ImageView hotelPic;
    private byte[] photo;
    private Bitmap bp;

    AppDatabase mydb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        mydb = new AppDatabase(this);
        hotelPic = (ImageView) findViewById(R.id.hotel_imageView);
        submitHotelDetails = (Button) findViewById(R.id.hotel_details_save_button);
        roomType1Button = (Button) findViewById(R.id.room_type_1_button);
        roomType2Button = (Button) findViewById(R.id.room_type_2_button);
        roomType3Button = (Button) findViewById(R.id.room_type_3_button);
        hotelId = (EditText) findViewById(R.id.hotel_id_box);
        hotalName = (EditText) findViewById(R.id.hotel_name_box);
        hotelCity = (EditText) findViewById(R.id.hotel_city_box);
        contactPerson = (EditText) findViewById(R.id.hotel_contact_person_box);
        contactNo = (EditText) findViewById(R.id.hotel_contact_number_box);
        starRating = (EditText) findViewById(R.id.hotel_star_rating_box);
        Description = (EditText) findViewById(R.id.hotel_description_box);
        rt1_Editext = (EditText) findViewById(R.id.room_type_1_EditText);
        rt2_EditText = (EditText) findViewById(R.id.room_type_2_EditText);
        rt3_EditText = (EditText) findViewById(R.id.room_type_3_EditText);
        imagepath = findViewById(R.id.imagePath);
        submitHotelDetails.setOnClickListener(this);
        roomType1Button.setOnClickListener(this);
        roomType2Button.setOnClickListener(this);
        roomType3Button.setOnClickListener(this);
        hotelPic.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel_details_save_button:

                        boolean Inserted = mydb.insertDataHotel(hotelId.getText().toString(), hotalName.getText().toString(), hotelCity.getText().toString(), contactPerson.getText().toString(), contactNo.getText().toString(), starRating.getText().toString(), Description.getText().toString(), rt1_Editext.getText().toString(), rt2_EditText.getText().toString(), rt3_EditText.getText().toString(), gethImage());
                        if (Inserted) {
                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data Not Inserted", Toast.LENGTH_LONG).show();
                        }

//                builder1.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        boolean Update = mydb.updateHotelData(hotelId.getText().toString(), hotalName.getText().toString(), hotelCity.getText().toString(), contactPerson.getText().toString(), contactNo.getText().toString(), starRating.getText().toString(), Description.getText().toString(), rt1_Editext.getText().toString(), rt2_EditText.getText().toString(), rt3_EditText.getText().toString(), gethImage());
//                        if (Update) {
//                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data Updated", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data not Updated", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//                builder1.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        int delete = mydb.deleteHotelData(hotelId.getText().toString());
//                        if (delete > 0) {
//                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data Deleted", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(HotelDetailsActivity.this, "Hotel Data not Deleted", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//                builder1.show();
                break;

            case R.id.room_type_1_button:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose From options");
                builder2.setPositiveButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt1_Editext.setText("Super Luxury");
                    }
                });
                builder2.setNegativeButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt2_EditText.setText("Luxury");
                    }
                });
                builder2.setNeutralButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt3_EditText.setText("Ordinary");
                    }
                });
                builder2.show();
                break;

            case R.id.room_type_2_button:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("Choose From options");
                builder3.setPositiveButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt1_Editext.setText("Super Luxury");
                    }
                });
                builder3.setNegativeButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt2_EditText.setText("Luxury");
                    }
                });
                builder3.setNeutralButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt3_EditText.setText("Ordinary");
                    }
                });
                builder3.show();
                break;

            case R.id.room_type_3_button:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle("Choose From options");
                builder4.setPositiveButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt1_Editext.setText("Super Luxury");
                    }
                });
                builder4.setNegativeButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt2_EditText.setText("Luxury");
                    }
                });
                builder4.setNeutralButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rt3_EditText.setText("Ordinary");
                    }
                });
                builder4.show();
                break;

            case R.id.hotel_imageView:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            bp = decodeUri(selectedImage);
            hotelPic.setImageURI(selectedImage);
        }

    }

    protected Bitmap decodeUri(Uri choosenImage) {
        Toast.makeText(HotelDetailsActivity.this, choosenImage.toString(), Toast.LENGTH_LONG).show();
        BitmapFactory.Options o = new BitmapFactory.Options();

        try {
           return BitmapFactory.decodeStream(getContentResolver().openInputStream(choosenImage), null, o);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
 private byte[] hImage(Bitmap b){
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     b.compress(Bitmap.CompressFormat.JPEG, 0, bos);
     return bos.toByteArray();
 }

 private byte[] gethImage(){
        photo = hImage(bp);
        return photo;
 }
}
