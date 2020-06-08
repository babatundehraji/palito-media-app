package com.palitomediaapp.palitomediang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.category));

        findViewById(R.id.category_education).setOnClickListener(this);
        findViewById(R.id.category_entertainment).setOnClickListener(this);
        findViewById(R.id.category_gist).setOnClickListener(this);
        findViewById(R.id.category_health).setOnClickListener(this);
        findViewById(R.id.category_international).setOnClickListener(this);
        findViewById(R.id.category_music).setOnClickListener(this);
        findViewById(R.id.category_news).setOnClickListener(this);
        findViewById(R.id.category_relationship).setOnClickListener(this);
        findViewById(R.id.category_sport).setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category_education:
//                educational link:
                goWebService("EDUCATION", "https://palitomedia.com.ng/category/education/");
                break;

            case R.id.category_entertainment:
                goWebService("ENTERTAINMENT/LIFE STYLE", "https://palitomedia.com.ng/category/entertainment/");
                break;
            case R.id.category_gist:
                goWebService("GIST", "https://palitomedia.com.ng/category/gist/");
                break;
            case R.id.category_health:
                goWebService("HEALTH", "https://palitomedia.com.ng/category/health/");
                break;
            case R.id.category_international:
                goWebService("INTERNATIONAL", "https://palitomedia.com.ng/category/international/");
                break;
            case R.id.category_music:
                goWebService("MUSIC", "https://palitomedia.com.ng/category/music/");
                break;
            case R.id.category_news:
                goWebService("NEWS", "https://palitomedia.com.ng/category/news/");
                break;
            case R.id.category_politics:
                goWebService("POLITICS", "https://palitomedia.com.ng/category/politics/");
                break;
            case R.id.category_relationship:
                goWebService("RELATIONSHIP", "https://palitomedia.com.ng/category/relationship/");
                break;
            case R.id.category_sport:
                goWebService("SPORT", "https://palitomedia.com.ng/category/sport/");
                break;
                default:
//                    do nothing
        }
    }

    private void goWebService(String title, String link) {
        Intent intent = new Intent(getApplicationContext(), WebserviceActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("link", link);
        startActivity(intent);
    }
}
