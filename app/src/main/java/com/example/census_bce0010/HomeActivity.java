package com.example.census_bce0010;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yuku.ambilwarna.AmbilWarnaDialog;

public class HomeActivity extends AppCompatActivity {
    ConstraintLayout mLayout;
    int mDefaultColor;

    Button mPreferences;
    Button Add_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mLayout = (ConstraintLayout) findViewById(R.id.layout);
        mDefaultColor = ContextCompat.getColor(HomeActivity.this, com.google.android.material.R.color.design_default_color_primary);
        Add_data = (Button)  findViewById(R.id.Add_data);
        Add_data.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this,AddDataActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            mPreferences =(Button) findViewById(R.id.Preferences);
            mPreferences.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Preferences();
                }
            });

        }

        public void Preferences(){
            AmbilWarnaDialog Preferences = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    mDefaultColor = color;
                    mLayout.setBackgroundColor(mDefaultColor);
                }
            });
            Preferences.show();
        }

    }
