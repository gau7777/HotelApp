package com.example.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuestRegisterFormActivity extends AppCompatActivity implements View.OnClickListener{
    EditText Gname;
    EditText GAddress;
    EditText GPhone;
    EditText GEmail;
    EditText GPassword;
    Button GLogin;
    AppDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_register_form);

        mydb = new AppDatabase(this);

        Gname = (EditText) findViewById(R.id.guestName);
        GAddress = (EditText) findViewById(R.id.guestAddress);
        GPhone = (EditText) findViewById(R.id.guestPhone);
        GEmail = (EditText) findViewById(R.id.guestEmail);
        GPassword = (EditText) findViewById(R.id.guestPassword);
        GLogin = (Button) findViewById(R.id.guestLoginButton);

        GLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean Inserted = mydb.insertDataGuest(Gname.getText().toString(), GAddress.getText().toString(), GPhone.getText().toString(), GEmail.getText().toString(), GPassword.getText().toString());
        if(Inserted){
            Toast.makeText(GuestRegisterFormActivity.this, "Guest Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(GuestRegisterFormActivity.this, "Guest Data Not Inserted", Toast.LENGTH_LONG).show();
        }
    }
}

