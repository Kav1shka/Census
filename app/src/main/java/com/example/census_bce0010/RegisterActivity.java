package com.example.census_bce0010;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    Button button;
    String BeforeBegin="yes";
    private EditText editText;
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences shared = getSharedPreferences(getString(R.string.census_bce0010), Context.MODE_PRIVATE);
        if (!shared.getBoolean(BeforeBegin, false)) {
            SharedPreferences.Editor editor = shared.edit();
            editor.putBoolean(BeforeBegin, Boolean.TRUE);
            editor.apply();
        } else {
            NextToLogin();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button=(Button)findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Objects.requireNonNull(getSupportActionBar()).hide();

        editText = (EditText) findViewById(R.id.New_password);
    }

    public void onclick(View view) {
        String passwordInput = editText.getText().toString().trim();
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(passwordInput.isEmpty()){
            editText.setError("Password field can't be empty");
        }else if(passwordInput.length()<6){
            editText.setError("Password should be more than 5 characters");
        }else{
            editText.setError(null);
            editor.putString("password",editText.getText().toString());
            editor.putBoolean("REGISTERED",true);
            editor.apply();
            Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
    public void NextToLogin(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}