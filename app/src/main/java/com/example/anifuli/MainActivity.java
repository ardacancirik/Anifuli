package com.example.anifuli;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister, btnLogin;
    private EditText logUsername, logPassword;
    private CheckBox showPassword;
    DBcreator DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logUsername = (EditText) findViewById(R.id.logUsername);
        logPassword = (EditText) findViewById(R.id.logPassword);
        btnLogin = (Button) (findViewById(R.id.btnLogin));
        btnRegister = (Button) (findViewById(R.id.btnRegister));
        showPassword = (CheckBox) (findViewById(R.id.showPassword));
        DB = new DBcreator(this);


        showPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegister:
                openRegisterActivity();
                break;

            case R.id.btnLogin:
                String username = logUsername.getText().toString();
                String password = logPassword.getText().toString();
                User user = new User(username, password);

                if(username.equals("")||password.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all the values.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkUsernamePassword(username, password);
                    if(checkuserpass == true){
                        Toast.makeText(MainActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        openmainMenuActivity();
                    }else{
                        showErrorMassage();
                    }
                }

                break;

            case R.id.showPassword:
                if(showPassword.isChecked()){
                    logPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);;
                }else{
                    logPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                break;
        }
    }

    private void showErrorMassage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        dialogBuilder.setMessage("Incorrect user details!");
        dialogBuilder.setPositiveButton("ok", null);
        dialogBuilder.show();
    }

    public void openRegisterActivity(){
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

    public void openmainMenuActivity(){
        Intent intent = new Intent(this, mainMenuActivity.class);
        startActivity(intent);
    }




}