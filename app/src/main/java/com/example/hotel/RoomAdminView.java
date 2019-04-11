package com.example.hotel;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class RoomAdminView extends AppCompatActivity implements View.OnClickListener{
    Button submitRoomDetailsView,roomTypeButtonView;
    EditText roomIdView;
    EditText roomTypeView;
    EditText room2TypeView;
    EditText room3TypeView;
    EditText hotelRoomIdView;
    EditText ONoOfRoomsView;
    EditText LNoOfRoomsView;
    EditText SNoOfRoomsView;
    EditText OPriceView;
    EditText LPriceView;
    EditText SPriceView;
    EditText ODescriptionView;
    EditText LDescriptionView;
    EditText SDescriptionView;
    Button room2ButtonView, room3ButtonView;
    ImageView Room1PhotoView;
    ImageView Room2PhotoView;
    ImageView Room3PhotoView;
    public static final int RESULT_LOAD_IMAGE_1 = 1;
    public static final int RESULT_LOAD_IMAGE_2 = 2;
    public static final int RESULT_LOAD_IMAGE_3 = 3;
    byte[] roomPhoto1View;
    byte[] roomPhoto2View;
    byte[] roomPhoto3View;
    Bitmap bp1View, bp2View, bp3View, bm1View, bm2View, bm3View;
    AppDatabase mydb = null;
    String RType1, RType2, RType3, HR2, HR3, ORDes, LRDes, SRDes;
    int Rid, HRid, ORNo, LRNo, SRNo, ORPr, LRPr, SRPr;
    byte[] Rphoto1, Rphoto2, Rphoto3, pv1View, pv2View, pv3View;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_modify);

        mydb = new AppDatabase(this);
        submitRoomDetailsView = (Button) findViewById(R.id.room_details_save_button_View);
        roomIdView = (EditText) findViewById(R.id.room_id_box_View);
        roomTypeView = (EditText) findViewById(R.id.room_type_box_View);
        roomTypeButtonView = (Button) findViewById(R.id.room_type1_button_View);
        hotelRoomIdView = (EditText) findViewById(R.id.hotel_room_id_box_View);
        ONoOfRoomsView = (EditText) findViewById(R.id.O_no_of_rooms_box_View);
        OPriceView = (EditText) findViewById(R.id.Price_O_Box_View);
        ODescriptionView = (EditText) findViewById(R.id.Description_O_box_View);
        LNoOfRoomsView = (EditText) findViewById(R.id.L_no_of_rooms_box_View);
        LPriceView = (EditText) findViewById(R.id.Price_L_Box_View);
        LDescriptionView = (EditText) findViewById(R.id.Description_L_box_View);
        SNoOfRoomsView = (EditText) findViewById(R.id.S_no_of_Rooms_box_View);
        SPriceView = (EditText) findViewById(R.id.Price_S_box_View);
        SDescriptionView = (EditText) findViewById(R.id.Description_S_box_View);
        Room1PhotoView = (ImageView) findViewById(R.id.Room1_imageView_View);
        Room2PhotoView = (ImageView) findViewById(R.id.Room2_imageView_View);
        Room3PhotoView = (ImageView) findViewById(R.id.Room3_imageView_View);
        room2ButtonView = (Button) findViewById(R.id.room_type2_button_View);
        room3ButtonView = (Button) findViewById(R.id.room_type3_button_View);
        room2TypeView = (EditText) findViewById(R.id.room_type2_EditText_View);
        room3TypeView = (EditText) findViewById(R.id.room_type3_EditText_View);



        submitRoomDetailsView.setOnClickListener(this);
        roomTypeButtonView.setOnClickListener(this);
        room2ButtonView.setOnClickListener(this);
        room3ButtonView.setOnClickListener(this);
        Room1PhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent1, RESULT_LOAD_IMAGE_1);
            }
        });
        Room2PhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent2, RESULT_LOAD_IMAGE_2);
            }
        });
        Room3PhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent3 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent3, RESULT_LOAD_IMAGE_3);
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            Rid = intent.getIntExtra("Rid", 0);
            RType1 = intent.getStringExtra("Type1");
            RType2 = intent.getStringExtra("Type2");
            RType3 = intent.getStringExtra("Type3");
            HRid = intent.getIntExtra("HRid", 0);
            ORNo = intent.getIntExtra("ONoR",0);
            ORPr = intent.getIntExtra("ORPr", 0);
            ORDes = intent.getStringExtra("ORDes");
            LRNo = intent.getIntExtra("LNoR",0);
            LRPr = intent.getIntExtra("LRPr", 0);
            LRDes = intent.getStringExtra("LRDes");
            SRNo = intent.getIntExtra("SNoR",0);
            SRPr = intent.getIntExtra("SRPr", 0);
            SRDes = intent.getStringExtra("SRDes");
            Rphoto1 = intent.getByteArrayExtra("RImage1");
            Rphoto2 = intent.getByteArrayExtra("RImage2");
            Rphoto3 = intent.getByteArrayExtra("RImage3");
        }

        roomIdView.setText(Rid + "");
        roomTypeView.setText(RType1);
        room2TypeView.setText(RType2);
        room3TypeView.setText(RType3);
        hotelRoomIdView.setText(HRid + "");
        ONoOfRoomsView.setText(ORNo + "");
        OPriceView.setText(ORPr + "");
        ODescriptionView.setText(ORDes);
        LNoOfRoomsView.setText(LRNo + "");
        LPriceView.setText(LRPr + "");
        LDescriptionView.setText(LRDes);
        SNoOfRoomsView.setText(SRNo + "");
        SPriceView.setText(SRPr + "");
        SDescriptionView.setText(SRDes);
        Room1PhotoView.setImageBitmap(convertToBitmap(Rphoto1));
        Room2PhotoView.setImageBitmap(convertToBitmap(Rphoto2));
        Room3PhotoView.setImageBitmap(convertToBitmap(Rphoto3));

        bm1View = ((BitmapDrawable) Room1PhotoView.getDrawable()).getBitmap();
        bm2View = ((BitmapDrawable) Room2PhotoView.getDrawable()).getBitmap();
        bm3View = ((BitmapDrawable) Room3PhotoView.getDrawable()).getBitmap();
        pv1View = hImage(bm1View);
        pv2View = hImage(bm2View);
        pv3View = hImage(bm3View);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.room_details_save_button_View:
            if((Room1PhotoView.isSelected() || Room2PhotoView.isSelected() || Room3PhotoView.isSelected()) || (Room1PhotoView.isSelected() && Room2PhotoView.isSelected() && Room3PhotoView.isSelected())) {
                boolean Update = mydb.updateRoomData(roomIdView.getText().toString(), roomTypeView.getText().toString(), room2TypeView.getText().toString(), room3TypeView.getText().toString(), hotelRoomIdView.getText().toString(), ONoOfRoomsView.getText().toString(), OPriceView.getText().toString(), ODescriptionView.getText().toString(), LNoOfRoomsView.getText().toString(), LPriceView.getText().toString(), LDescriptionView.getText().toString(), SNoOfRoomsView.getText().toString(), SPriceView.getText().toString(), SDescriptionView.getText().toString(), gethImage1View(), gethImage2View(), gethImage3View());
                if (Update) {
                    Toast.makeText(RoomAdminView.this, "Room Data Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RoomAdminView.this, "Room Data Not Updated", Toast.LENGTH_LONG).show();
                }
            } else if(!((Room1PhotoView.isSelected() || Room2PhotoView.isSelected() || Room3PhotoView.isSelected()) || (Room1PhotoView.isSelected() && Room2PhotoView.isSelected() && Room3PhotoView.isSelected()))){
                boolean Update = mydb.updateRoomData(roomIdView.getText().toString(), roomTypeView.getText().toString(), room2TypeView.getText().toString(), room3TypeView.getText().toString(), hotelRoomIdView.getText().toString(), ONoOfRoomsView.getText().toString(), OPriceView.getText().toString(), ODescriptionView.getText().toString(), LNoOfRoomsView.getText().toString(), LPriceView.getText().toString(), LDescriptionView.getText().toString(), SNoOfRoomsView.getText().toString(), SPriceView.getText().toString(), SDescriptionView.getText().toString(), pv1View, pv2View, pv3View);
                if (Update) {
                    Toast.makeText(RoomAdminView.this, "Room Data Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RoomAdminView.this, "Room Data Not Updated", Toast.LENGTH_LONG).show();
                }
            }

                break;
            case R.id.room_type1_button:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose from options");
                builder2.setNeutralButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        roomTypeView.setText("Super Luxury");
                    }
                });
                builder2.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        roomTypeView.setText("Luxury");
                    }
                });
                builder2.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        roomTypeView.setText("Ordinary");
                    }
                });

                builder2.show();
                break;

            case R.id.room_type2_button:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("Choose from options");
                builder3.setNeutralButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room2TypeView.setText("Super Luxury");
                    }
                });
                builder3.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room2TypeView.setText("Luxury");
                    }
                });
                builder3.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room2TypeView.setText("Ordinary");
                    }
                });

                builder3.show();
                break;

            case R.id.room_type3_button:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle("Choose from options");
                builder4.setNeutralButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room3TypeView.setText("Super Luxury");
                    }
                });
                builder4.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room3TypeView.setText("Luxury");
                    }
                });
                builder4.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room3TypeView.setText("Ordinary");
                    }
                });

                builder4.show();
                break;




            default:
                break;

        }

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Uri uri = Uri.parse("android.resource://com.example.hotel/drawable/hotel");
        byte[] byte1 = savedInstanceState.getByteArray("1");
        byte[] byte2 = savedInstanceState.getByteArray("2");
        byte[] byte3 = savedInstanceState.getByteArray("3");



        Room1PhotoView.setImageBitmap(convertToBitmap(byte1));
        if(byte2==null){

            Room2PhotoView.setImageURI(uri);

        }else{
            Room2PhotoView.setImageBitmap(convertToBitmap(byte2));
        }


        if(byte3==null){

            Room3PhotoView.setImageURI(uri);

        }else{
            Room3PhotoView.setImageBitmap(convertToBitmap(byte3));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // String[] string = {s1.getText().toString(),s2.getText().toString(),s3.getText().toString()};
        //outState.putStringArray("values",string);
        outState.putByteArray("1",roomPhoto1View);
        outState.putByteArray("2",roomPhoto2View);
        outState.putByteArray("3",roomPhoto3View);
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




//        if(resultCode==RESULT_OK && requestCode==RESULT_LOAD_IMAGE_1 && data!=null){
//
//        }
//
//        else if(resultCode==RESULT_OK && requestCode==RESULT_LOAD_IMAGE_2 && data!=null){
//            Uri selectedImage2 = data.getData();
//            bp2 = decodeUri(selectedImage2);
//            Room2Photo.setImageURI(selectedImage2);
//        }
//        else if(resultCode==RESULT_OK && requestCode==RESULT_LOAD_IMAGE_3 && data!=null){
//            Uri selectedImage3 = data.getData();
//            bp3 = decodeUri(selectedImage3);
//            Room3Photo.setImageURI(selectedImage3);
//        }
        switch(requestCode){
            case RESULT_LOAD_IMAGE_1:

                if (resultCode == RESULT_OK && data != null) {
                    Uri selectedImage1 = data.getData();


                    bp1View = decodeUri(selectedImage1);
                    Room1PhotoView.setImageURI(selectedImage1);
                }
                break;

            case RESULT_LOAD_IMAGE_2:
                if(resultCode == RESULT_OK && data != null){
                    Uri selectedimage2 = data.getData();
                    bp2View = decodeUri(selectedimage2);
                    Room2PhotoView.setImageURI(selectedimage2);


                }
                break;

            case RESULT_LOAD_IMAGE_3:
                if(resultCode == RESULT_OK && data != null){
                    Uri selectedimage3 = data.getData();
                    bp3View = decodeUri(selectedimage3);
                    Room3PhotoView.setImageURI(selectedimage3);

                }

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
    private byte[] hImage(Bitmap b){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 0, bos);
        return bos.toByteArray();
    }

    private byte[] gethImage1View(){
        roomPhoto1View = hImage(bp1View);
        return roomPhoto1View;
    }

    private byte[] gethImage2View(){
        roomPhoto2View = hImage(bp2View);
        return roomPhoto2View;
    }

    private byte[] gethImage3View(){
        roomPhoto3View = hImage(bp3View);
        return roomPhoto3View;
    }
    private Bitmap convertToBitmap(byte[] b) {
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }

}

