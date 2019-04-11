package com.example.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button adminLogin;
    EditText adminName;
    EditText adminpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminLogin = (Button) findViewById(R.id.admin_login_button);
        adminName = (EditText) findViewById(R.id.admin_email_login_editText);
        adminpass = (EditText) findViewById(R.id.admin_password_login_editText);

        adminLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(adminName.getText().toString().equals("Gaurav") && adminpass.getText().toString().equals("guruji")){
            Intent intent = new Intent(this, AdminMenuActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(AdminLoginActivity.this, "Sorry, please try again", Toast.LENGTH_LONG).show();
        }
    }
}
