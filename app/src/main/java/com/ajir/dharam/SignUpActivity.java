package com.ajir.dharam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText edit_username, edit_phone,edit_password;
    Button btn_submit;
    DatabaseHelper dbheHelper;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        pref = getSharedPreferences("signup", Context.MODE_PRIVATE);
        editor = pref.edit();
        edit_username = findViewById(R.id.edit_username);
        edit_phone = findViewById(R.id.edit_phone);
        edit_password = findViewById(R.id.edit_password);

        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = edit_username.getText().toString();

                if (Username.equals("") || !Username.matches("((?=.*\\d)(?=.*[a-zA-Z]).{8,20})")){
                    Toast.makeText(SignUpActivity.this, "please enter username with atleast one character and one digit with minimum length 8 and maxlength 20 ", Toast.LENGTH_LONG).show();
                    return;
                }

                String Phone = edit_phone.getText().toString();

                if (Phone.equals("") || Phone.length()!=10){
                    Toast.makeText(SignUpActivity.this, "please enter valid 10 digit phone no", Toast.LENGTH_LONG).show();
                    return;
                }

                String Passwrd = edit_password.getText().toString();

                if (Passwrd.equals("") ||!Passwrd.matches("((?=.*\\d)(?=.*[a-zA-Z]).{8,15})")){
                    Toast.makeText(SignUpActivity.this, "\"please enter Password with atleast one character and one digit with minimum length 8 and maxlength 15 \"", Toast.LENGTH_LONG).show();
                    return;
                }


                User user = new User();
                user.setName(Username);
                user.setPhone_number(Phone);
                user.setPassword(Passwrd);

                dbheHelper = new DatabaseHelper(getApplicationContext());
                dbheHelper.addUser(user);

                editor.putString("Username",null);
                editor.putString("Paswrd",null);

                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                intent.putExtra("user", Username);
                intent.putExtra("pass",Passwrd);
                startActivity(intent);
                finish();
            }
        });
    }
}
