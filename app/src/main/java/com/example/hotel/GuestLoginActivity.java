package com.example.hotel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuestLoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button guestLogin;
    EditText loginEmail;
    EditText LoginPassword;
    Guests guests;
    AppDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);

        mydb = new AppDatabase(this);
        guestLogin = (Button) findViewById(R.id.guest_login_button);
        loginEmail = (EditText) findViewById(R.id.guest_email_login_editText);
        LoginPassword = (EditText) findViewById(R.id.guest_password_login_editText);
        guestLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int f = 0;
        Cursor res = mydb.getGuestData();
        if ((res != null) && (res.moveToFirst())) {
            do {
                int Nemail = res.getColumnIndex(GuestsContract.Columns.GUEST_EMAIL);
                int Npass = res.getColumnIndex(GuestsContract.Columns.GUEST_PASSWORD);

                if (loginEmail.getText().toString().equals(res.getString(Nemail)) && LoginPassword.getText().toString().equals(res.getString(Npass))) {
                                     f=1;
                                     break;
                } else {
                                 f=0;
                }
            } while (res.moveToNext());

            if(f == 1){
                Toast.makeText(GuestLoginActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, HotelListActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(GuestLoginActivity.this, "Please try again", Toast.LENGTH_LONG).show();
            }
        }
    }

}
