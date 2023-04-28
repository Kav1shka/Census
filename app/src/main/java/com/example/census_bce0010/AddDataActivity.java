package com.example.census_bce0010;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
//import android.support.annotation.Nullable;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Objects;

public class AddDataActivity extends AppCompatActivity {
    ImageView imageView;
    Button camButton;

    EditText name,age;
    Button save,view;

    RadioButton genderbutton;
    RadioGroup gender;

    DatabaseActivity DB;
    String img,eccodedImage;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        Objects.requireNonNull(getSupportActionBar()).hide();

        //open camera
        imageView = findViewById(R.id.profilePhoto);
        camButton = findViewById(R.id.camBtn);

        if(ContextCompat.checkSelfPermission(AddDataActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(AddDataActivity.this,
                    new String[]{Manifest.permission.CAMERA}, 101);
        }

        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,101);
            }
        });

        //data store and view

        name = (EditText) findViewById(R.id.editTextTextPersonName);
        age = (EditText) findViewById(R.id.editTextNumber);
        save = (Button) findViewById(R.id.save);
        gender = (RadioGroup) findViewById(R.id.gender);
        view = (Button) findViewById(R.id.viewBtn);


        //Radio Button input

        DB = new DatabaseActivity(this);
//        female = findViewById(R.id.femaleBtn);
//        male = findViewById(R.id.maleBtn);
//        findGender();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddDataActivity.this,ListDataAcivity.class));



            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ContentValues contentValues = new ContentValues();
////                if(male.isChecked()){
////                    contentValues.put("gender",male.getText().toString());
////                } else{
////                    contentValues.put("gender",female.getText().toString());
////                }
                int selectedId = gender.getCheckedRadioButtonId();
                genderbutton = (RadioButton) findViewById(selectedId);
                String nameTXT = name.getText().toString();
                String ageNUM = age.getText().toString();
                String genderTXT = genderbutton.getText().toString();
                String bitmap = img;
                System.out.println(genderTXT);

                if (selectedId == -1) {
                    System.out.println("empty");
                } else {
//                    Toast.makeText(Addlist.this, genderbutton.getText(), Toast.LENGTH_SHORT).show();


                    Boolean checkinsertdata = DB.insertuserdata(nameTXT,ageNUM,genderTXT,img);

                    if (checkinsertdata == true)
                    {
                        Toast.makeText(AddDataActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(AddDataActivity.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
                    }

                    name.getText().clear();
                    age.getText().clear();
                    gender.clearCheck();
                }
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            assert data != null;
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,bytearray);
            byte[] img = bytearray.toByteArray();
//            eccodedImage = Base64.encodeToString(img,Base64.DEFAULT);

        }
    }
    }
