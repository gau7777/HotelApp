package com.example.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button adminButton;
    Button guestButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminButton = (Button) findViewById(R.id.admin_button);
        guestButton = (Button) findViewById(R.id.guest_button);

         adminButton.setOnClickListener(this);
         guestButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.admin_button:
                intent = new Intent(this, AdminLoginActivity.class);
                break;

            case R.id.guest_button:
                intent = new Intent(this, GuestRegisterLoginActivity.class);
                break;

            default:
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
