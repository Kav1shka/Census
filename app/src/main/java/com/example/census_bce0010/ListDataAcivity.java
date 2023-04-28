package com.example.census_bce0010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.census_bce0010.DatabaseActivity;
import com.example.census_bce0010.MyAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ListDataAcivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> name,age,gender,img;


    DatabaseActivity DB;

    Button uploadBtn;
    MyAdapter adapter;
    int[] id;

    private static final String TAG = "Data List";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_acivity);


        DB = new DatabaseActivity(this);
        name = new ArrayList<>();
        age = new ArrayList<>();
        gender = new ArrayList<>();
        img = new ArrayList<>();

        recyclerView = findViewById(R.id.recycleview);
        adapter = new MyAdapter(this,name,age,gender,img);

        uploadBtn = findViewById(R.id.uploadBtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        findGender();
        displaydata();
    }

    private void findGender() {
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
    }

    private void displaydata() {
        Cursor cursor =DB.getdata();

        if (cursor.getCount() == 0)
        {
            Toast.makeText( ListDataAcivity.this,"No Data Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                age.add(cursor.getString(1));
                gender.add(cursor.getString(2));
                img.add(cursor.getString(3));
            }
        }
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            //            String nameText = name.getText().toString();
//            String ageText = age.getText().toString();
//            String genderText = genderRadioButton.getText().toString();
            @Override
            public void onClick(View view) {

                Cursor cursor = DB.getdata();
                if (cursor.getCount()==0) {
                    Toast.makeText(ListDataAcivity.this, "No data entered", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    Map<String,Object> data = new HashMap<>();
                    while (cursor.moveToNext()){
                        String username = cursor.getString(0);
                        data.put("Name",cursor.getString(0)+"\n");
                        data.put("Age",cursor.getString(1)+"\n");
                        data.put("Gender",cursor.getString(2)+"\n");
                        data.put("Profile Photo",cursor.getString(3)+"\n");


                        //firebaseDB.collection("Cencus APP").document(username).set(data)
                        // .addOnSuccessListener(new OnSuccessListener<Void>() {
                        //  @Override
                        //  public void onSuccess(Void unused) {
                        //  Toast.makeText(Viewdata.this, "Saved to cloud", Toast.LENGTH_SHORT).show();
                        //  }
                        // })
                        // .addOnFailureListener(new OnFailureListener() {
                        //    @Override
                        //    public void onFailure(@NonNull Exception e) {
                        //     Toast.makeText(Viewdata.this, "Error in saving to cloud!", Toast.LENGTH_SHORT).show();
                        //    Log.d(TAG,e.toString());
                    }
                    // });
                }
            }
        });
    }
}