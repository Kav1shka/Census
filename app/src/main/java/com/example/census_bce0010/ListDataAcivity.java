package com.example.census_bce0010;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataAcivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,age,gender;
    //    ArrayList<Blob>img;
    DatabaseActivity DB;
    //Adapter adapter;
    int[] id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_acivity);
    }
//
//    DB = new DatabaseActivity(this);
//    name = new ArrayList<>();
//    age = new ArrayList<>();
//    gender = new ArrayList<>();
////        img = new ArrayList<>();
//    recyclerView = findViewById(R.id.recycleview);
//    adapter = new MyAdapter(this,name,age,gender);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    findGender();
//    displaydata();
//}
//
//    private void findGender() {
//        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
//    }
//
//    private void displaydata() {
//        Cursor cursor =DB.getdata();
//        if (cursor.getCount() == 0)
//        {
//            Toast.makeText( Viewdata.this,"No Data Exists", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            while(cursor.moveToNext())
//            {
//                name.add(cursor.getString(0));
//                age.add(cursor.getString(1));
//                gender.add(cursor.getString(2));
////                byte[] img = cursor.getBlob(3);
//            }
//        }
//    }
}