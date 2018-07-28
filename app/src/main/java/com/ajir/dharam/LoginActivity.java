package com.ajir.dharam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText login, password;
    Button btn_login, btn_signup;
    DatabaseHelper databaseHelper;
    SharedPreferences sharedPreferences;
    List<User> userList;

    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences sharedPreferences = getSharedPreferences("signup",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("logged" ,false)) {
            // Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MapsActivity.class);
            startActivity(intent);
            finish();
        }

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                final String Username = getIntent().getStringExtra("user");
                final String Paswrd = getIntent().getStringExtra("pass");

                if(login.getText().toString().equals(Username) && password.getText().toString().equals(Paswrd) ){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("logged",true);
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
