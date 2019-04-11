package com.example.hotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class HotelAdminViewActivity extends AppCompatActivity implements View.OnClickListener {
    Button HotelUpdate;
    TextView t1;
    EditText hotelIdView;
    EditText hotalNameView;
    EditText hotelCityView;
    EditText contactPersonView;
    EditText contactNoView;
    EditText starRatingView;
    EditText DescriptionView;
    EditText rt1_EditextView;
    EditText rt2_EditTextView;
    EditText rt3_EditTextView;
    ImageView hotelPicView;
    private byte[] photoView, pv;
    private Bitmap bpView, bm;
    public static final int RESULT_LOAD_IMAGE = 1;

    String HName, HLocation, HContactPerson, HDescription, HR1, HR2, HR3;
    int Hid, HContactNo, HRating, pos;
    byte[] Hphoto, samePicUpdate;

    AppDatabase mydb = null;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_modify);
        mydb = new AppDatabase(this);

        HotelUpdate = (Button) findViewById(R.id.hotel_details_save_button_View);
        hotelIdView = (EditText) findViewById(R.id.hotel_id_box_View);
        hotalNameView = (EditText) findViewById(R.id.hotel_name_box_View);
        hotelCityView = (EditText) findViewById(R.id.hotel_city_box_View);
        contactPersonView = (EditText) findViewById(R.id.hotel_contact_person_box_View);
        contactNoView = (EditText) findViewById(R.id.hotel_contact_number_box_View);
        starRatingView = (EditText) findViewById(R.id.hotel_star_rating_box_View);
        DescriptionView = (EditText) findViewById(R.id.hotel_description_box_View);
        rt1_EditextView = (EditText) findViewById(R.id.room_type_1_EditText_View);
        rt2_EditTextView = (EditText) findViewById(R.id.room_type_2_EditText_View);
        rt3_EditTextView = (EditText) findViewById(R.id.room_type_3_EditText_View);
        hotelPicView = (ImageView) findViewById(R.id.hotel_imageView_View);
        t1 = (TextView) findViewById(R.id.txt1);
        HotelUpdate.setOnClickListener(this);
        hotelPicView.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null) {
            Hid = intent.getIntExtra("id", 0);
            HName = intent.getStringExtra("Name");
            HLocation = intent.getStringExtra("Location");
            HContactPerson = intent.getStringExtra("ContactPerson");
            HContactNo = intent.getIntExtra("ContactNumber", 0);
            HRating = intent.getIntExtra("StarRating", 0);
            HDescription = intent.getStringExtra("Description");
            HR1 = intent.getStringExtra("RType1");
            HR2 = intent.getStringExtra("RType2");
            HR3 = intent.getStringExtra("RType3");
            Hphoto = intent.getByteArrayExtra("HotelImage");
        }

        pos = intent.getIntExtra("Position", 0);

        hotelIdView.setText(Hid + "");
        hotalNameView.setText(HName);
        hotelCityView.setText(HLocation);
        contactPersonView.setText(HContactPerson);
        contactNoView.setText(HContactNo + "");
        starRatingView.setText(HRating + "");
        DescriptionView.setText(HDescription);
        rt1_EditextView.setText(HR1);
        rt2_EditTextView.setText(HR2);
        rt3_EditTextView.setText(HR3);
        hotelPicView.setImageBitmap(convertToBitmap(Hphoto));
        bm = ((BitmapDrawable) hotelPicView.getDrawable()).getBitmap();
        pv = hImage(bm);

    }


    private Bitmap convertToBitmap(byte[] a) {
        return BitmapFactory.decodeByteArray(a, 0, a.length);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel_details_save_button_View:
                    if(hotelPicView.isSelected()) {
                        boolean Update = mydb.updateHotelData(hotelIdView.getText().toString(), hotalNameView.getText().toString(), hotelCityView.getText().toString(), contactPersonView.getText().toString(), contactNoView.getText().toString(), starRatingView.getText().toString(), DescriptionView.getText().toString(), rt1_EditextView.getText().toString(), rt2_EditTextView.getText().toString(), rt3_EditTextView.getText().toString(), gethImageView());
                        if (Update) {
                            Toast.makeText(HotelAdminViewActivity.this, "Hotel Data Updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(HotelAdminViewActivity.this, "Hotel Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }else if(!(hotelPicView.isSelected())){
                        boolean Update = mydb.updateHotelData(hotelIdView.getText().toString(), hotalNameView.getText().toString(), hotelCityView.getText().toString(), contactPersonView.getText().toString(), contactNoView.getText().toString(), starRatingView.getText().toString(), DescriptionView.getText().toString(), rt1_EditextView.getText().toString(), rt2_EditTextView.getText().toString(), rt3_EditTextView.getText().toString(), pv);
                        if (Update) {
                            Toast.makeText(HotelAdminViewActivity.this, "Hotel Data Updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(HotelAdminViewActivity.this, "Hotel Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                break;

            case R.id.hotel_imageView_View:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            bpView = decodeUri(selectedImage);
            hotelPicView.setImageURI(selectedImage);
        }

    }

    protected Bitmap decodeUri(Uri choosenImage) {

        BitmapFactory.Options o = new BitmapFactory.Options();

        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(choosenImage), null, o);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private byte[] hImage(Bitmap b) {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 0, bos);
            return bos.toByteArray();


    }

    private byte[] gethImageView(){
        photoView = hImage(bpView);
        return photoView;
    }

//    private byte[] gethImageViewSame(){
//        pv = hImage(bm);
//        return pv;
//    }
}