package com.example.mahdi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.ensias_auth_library.FoxyAuth;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        FoxyAuth.emerge(this,MainAppActivity.class);
    }



    public void OpensettingsActivity(View view) {
        Intent i = new Intent(this, AudioSettingsActivity.class);
        startActivity(i);
    }


    public void playGame(View view) {
        Intent i = new Intent(this, MainAppActivity.class);
        startActivity(i);
    }
}
