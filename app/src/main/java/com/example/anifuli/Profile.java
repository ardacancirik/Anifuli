package com.example.anifuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etName, etUsername, etMail, textPassword;
    DBcreator DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = (EditText) findViewById(R.id.textName);
        etMail = (EditText) findViewById(R.id.textMail);
        etUsername = (EditText) findViewById(R.id.textUsername);
        textPassword = (EditText) findViewById(R.id.textPassword);
        bLogout = (Button) findViewById(R.id.bLogout);
        DB = new DBcreator(this);

        bLogout.setOnClickListener(this);

        DB.open();

        Cursor cursor = DB.fetch();
        cursor.moveToFirst();
        etUsername.setText(cursor.getString(0));
        etName.setText(cursor.getString(1));
        etMail.setText(cursor.getString(2));
        textPassword.setText(cursor.getString(3));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                openMainActivity();
                break;
        }
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}