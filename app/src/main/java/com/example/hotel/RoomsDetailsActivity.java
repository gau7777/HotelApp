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

public class RoomsDetailsActivity extends AppCompatActivity implements View.OnClickListener{
         Button submitRoomDetails,roomTypeButton;
         EditText roomId;
         EditText roomType;
         EditText room2Type;
         EditText room3Type;
         EditText hotelRoomId;
         EditText ONoOfRooms;
         EditText LNoOfRooms;
         EditText SNoOfRooms;
         EditText OPrice;
         EditText LPrice;
         EditText SPrice;
         EditText ODescription;
         EditText LDescription;
         EditText SDescription;
         Button room2Button, room3Button;
         ImageView Room1Photo;
         ImageView Room2Photo;
         ImageView Room3Photo;
         public static final int RESULT_LOAD_IMAGE_1 = 1;
    public static final int RESULT_LOAD_IMAGE_2 = 2;
    public static final int RESULT_LOAD_IMAGE_3 = 3;
         byte[] roomPhoto1;
         byte[] roomPhoto2;
         byte[] roomPhoto3;
         Bitmap bp1, bp2, bp3;
         AppDatabase mydb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_details);

        mydb = new AppDatabase(this);
        submitRoomDetails = (Button) findViewById(R.id.room_details_save_button);
        roomId = (EditText) findViewById(R.id.room_id_box);
        roomType = (EditText) findViewById(R.id.room_type_box);
        roomTypeButton = (Button) findViewById(R.id.room_type1_button);
        hotelRoomId = (EditText) findViewById(R.id.hotel_room_id_box);
        ONoOfRooms = (EditText) findViewById(R.id.O_no_of_rooms_box);
        OPrice = (EditText) findViewById(R.id.Price_O_Box);
        ODescription = (EditText) findViewById(R.id.Description_O_box);
        LNoOfRooms = (EditText) findViewById(R.id.L_no_of_rooms_box);
        LPrice = (EditText) findViewById(R.id.Price_L_Box);
        LDescription = (EditText) findViewById(R.id.Description_L_box);
        SNoOfRooms = (EditText) findViewById(R.id.S_no_of_Rooms_box);
        SPrice = (EditText) findViewById(R.id.Price_S_box);
        SDescription = (EditText) findViewById(R.id.Description_S_box);
        Room1Photo = (ImageView) findViewById(R.id.Room1_imageView);
        Room2Photo = (ImageView) findViewById(R.id.Room2_imageView);
        Room3Photo = (ImageView) findViewById(R.id.Room3_imageView);
        room2Button = (Button) findViewById(R.id.room_type2_button);
        room3Button = (Button) findViewById(R.id.room_type3_button);
        room2Type = (EditText) findViewById(R.id.room_type2_EditText);
        room3Type = (EditText) findViewById(R.id.room_type3_EditText);



        submitRoomDetails.setOnClickListener(this);
        roomTypeButton.setOnClickListener(this);
        room2Button.setOnClickListener(this);
        room3Button.setOnClickListener(this);
        Room1Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent1, RESULT_LOAD_IMAGE_1);
            }
        });
        Room2Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent2, RESULT_LOAD_IMAGE_2);
            }
        });
        Room3Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent3 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent3, RESULT_LOAD_IMAGE_3);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.room_details_save_button:

                        boolean Inserted = mydb.insertDataRoom(roomId.getText().toString(), roomType.getText().toString(), room2Type.getText().toString(), room3Type.getText().toString(), hotelRoomId.getText().toString(), ONoOfRooms.getText().toString(), OPrice.getText().toString(), ODescription.getText().toString(), LNoOfRooms.getText().toString(), LPrice.getText().toString(), LDescription.getText().toString(), SNoOfRooms.getText().toString(), SPrice.getText().toString(), SDescription.getText().toString(), gethImage1(), gethImage2(), gethImage3());
                        if(Inserted){
                            Toast.makeText(RoomsDetailsActivity.this, "Room Data Inserted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(RoomsDetailsActivity.this, "Room Data Not Inserted", Toast.LENGTH_LONG).show();
                        }
//                    }
//                });
//                builder1.setPositiveButton("EDIT", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                      boolean Update = mydb.updateRoomData(roomId.getText().toString(), roomType.getText().toString(), room2Type.getText().toString(), room3Type.getText().toString(), hotelRoomId.getText().toString(), ONoOfRooms.getText().toString(), OPrice.getText().toString(), ODescription.getText().toString(), LNoOfRooms.getText().toString(), LPrice.getText().toString(), LDescription.getText().toString(), SNoOfRooms.getText().toString(), SPrice.getText().toString(), SDescription.getText().toString(), gethImage1(), gethImage2(), gethImage3());
//                      if(Update){
//                          Toast.makeText(RoomsDetailsActivity.this, "Room Data Updated", Toast.LENGTH_LONG).show();
//                      }else
//                      {
//                          Toast.makeText(RoomsDetailsActivity.this, "Room Data Not Updated", Toast.LENGTH_LONG).show();
//                      }
//                    }
//                });
//                builder1.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        int delete = mydb.deleteRoomData(hotelRoomId.getText().toString());
//                                if(delete>0){
//                                    Toast.makeText(RoomsDetailsActivity.this, "Room Data Deleleted", Toast.LENGTH_LONG).show();
//                                    SQLiteDatabase db;
//
//                                }
//                                else{
//                                    Toast.makeText(RoomsDetailsActivity.this, "Room Data Not Deleted", Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//                builder1.show();
                break;
            case R.id.room_type1_button:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose from options");
                builder2.setNeutralButton("Super Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                              roomType.setText("Super Luxury");
                    }
                });
                builder2.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                             roomType.setText("Luxury");
                    }
                });
                builder2.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                roomType.setText("Ordinary");
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
                        room2Type.setText("Super Luxury");
                    }
                });
                builder3.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room2Type.setText("Luxury");
                    }
                });
                builder3.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room2Type.setText("Ordinary");
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
                        room3Type.setText("Super Luxury");
                    }
                });
                builder4.setPositiveButton("Luxury", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room3Type.setText("Luxury");
                    }
                });
                builder4.setNegativeButton("Ordinary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        room3Type.setText("Ordinary");
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



        Room1Photo.setImageBitmap(convertToBitmap(byte1));
        if(byte2==null){

            Room2Photo.setImageURI(uri);

        }else{
            Room2Photo.setImageBitmap(convertToBitmap(byte2));
        }


        if(byte3==null){

            Room3Photo.setImageURI(uri);

        }else{
            Room3Photo.setImageBitmap(convertToBitmap(byte3));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

       // String[] string = {s1.getText().toString(),s2.getText().toString(),s3.getText().toString()};
        //outState.putStringArray("values",string);
        outState.putByteArray("1",roomPhoto1);
        outState.putByteArray("2",roomPhoto2);
        outState.putByteArray("3",roomPhoto3);
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


            bp1 = decodeUri(selectedImage1);
            Room1Photo.setImageURI(selectedImage1);
                }
                break;

            case RESULT_LOAD_IMAGE_2:
                if(resultCode == RESULT_OK && data != null){
                    Uri selectedimage2 = data.getData();
                    bp2 = decodeUri(selectedimage2);
                    Room2Photo.setImageURI(selectedimage2);


                }
                break;

                case RESULT_LOAD_IMAGE_3:
                if(resultCode == RESULT_OK && data != null){
                    Uri selectedimage3 = data.getData();
                    bp3 = decodeUri(selectedimage3);
                    Room3Photo.setImageURI(selectedimage3);

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

    private byte[] gethImage1(){
        roomPhoto1 = hImage(bp1);
        return roomPhoto1;
    }

    private byte[] gethImage2(){
        roomPhoto2 = hImage(bp2);
        return roomPhoto2;
    }

    private byte[] gethImage3(){
        roomPhoto3 = hImage(bp3);
        return roomPhoto3;
    }
    private Bitmap convertToBitmap(byte[] b) {
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }

}
