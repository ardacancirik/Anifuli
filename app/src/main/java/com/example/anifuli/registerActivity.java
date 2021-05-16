package com.example.anifuli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bRegister;
    private CheckBox showPassword;
    private EditText etName, etMail, etUsername, etPassword, etRePassword;
    public User user;
    DBcreator DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etMail = (EditText) findViewById(R.id.etMail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRePassword = (EditText) findViewById(R.id.etRePassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        showPassword = (CheckBox) findViewById(R.id.showPassword);
        DB = new DBcreator(this);


        bRegister.setOnClickListener(this);
        showPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String rePass = etRePassword.getText().toString();
                String mail = etMail.getText().toString();
                user = new User(name, mail, username, password);

                if (username.equals("")||password.equals("")||rePass.equals("")||mail.equals("")||name.equals("")) {
                    Toast.makeText(registerActivity.this, "Please enter all the values", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(rePass)){
                        Boolean checkUser = DB.checkUsername(username);
                        if (checkUser==false){
                            Boolean insert = DB.insertData(username, password, mail, name);
                            if (insert == true){
                                Toast.makeText(registerActivity.this, "Registered successfully.", Toast.LENGTH_SHORT).show();
                                openMainActivity();
                            }
                            else{
                                Toast.makeText(registerActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(registerActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(registerActivity.this, "Passwords not matching.", Toast.LENGTH_SHORT).show();
                    }
                }

            break;

            case R.id.showPassword:
                if(showPassword.isChecked()){
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    etRePassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    etRePassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                break;
        }

    }

    public void openMainActivity(){
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}