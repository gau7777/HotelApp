package com.example.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuestRegisterLoginActivity extends AppCompatActivity implements View.OnClickListener {
      Button guestRegister;
      Button guestLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_register_login);

        guestRegister = (Button) findViewById(R.id.guest_register_button);
        guestLogin = (Button) findViewById(R.id.guest_login_button);

        guestRegister.setOnClickListener(this);
        guestLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.guest_register_button:
                intent = new Intent(this, GuestRegisterFormActivity.class);
                break;

            case R.id.guest_login_button:
                intent = new Intent(this, GuestLoginActivity.class);
                break;

            default:
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
