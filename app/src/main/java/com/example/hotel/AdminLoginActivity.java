package com.example.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminLoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button adminLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminLogin = (Button) findViewById(R.id.admin_login_button);

        adminLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       Intent intent = new Intent(this, AdminMenuActivity.class);
       startActivity(intent);
    }
}
