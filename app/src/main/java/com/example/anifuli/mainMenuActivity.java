package com.example.anifuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnProfile, btnCategory, btnList, btnSearch, btnFav, btnRandom;
    EditText search_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btnProfile = (Button) (findViewById(R.id.btnProfile));
        btnCategory = (Button) (findViewById(R.id.btnCat));
        btnList = (Button) (findViewById(R.id.btnMyList));
        btnSearch = (Button) (findViewById(R.id.btnSearch));
        btnFav = (Button) (findViewById(R.id.btnFav));
        btnRandom = (Button) (findViewById(R.id.btnRandom));
        search_bar = (EditText) (findViewById(R.id.search_bar));
        btnProfile.setOnClickListener(this);
        btnFav.setOnClickListener(this);
        btnCategory.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnRandom.setOnClickListener(this);
        search_bar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnProfile:
                openProfileActivity();
                break;

            case R.id.btnCat:
                openCategoryActivity();
                break;

            case R.id.btnRandom:
                openAnimeInfoActivity();
                break;

            case R.id.btnMyList:
                openMyListActivity();
                break;

            case R.id.btnFav:
                openFavActivity();
                break;
        }
    }

    public void openAnimeInfoActivity(){
        Intent intent = new Intent(this,AnimeInfo.class);
        startActivity(intent);
    }

    public void openProfileActivity(){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }

    public void openCategoryActivity(){
        Intent intent = new Intent(this,Categories2.class);
        startActivity(intent);
    }

    public void openMyListActivity(){
        Intent intent = new Intent(this, MyList.class);
        startActivity(intent);
    }

    public void openFavActivity(){
        Intent intent = new Intent(this, Fav.class);
        startActivity(intent);
    }
}