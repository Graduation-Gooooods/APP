package com.example.jamjam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Passitive_btnClicked (View v){
        Intent intent1 = new Intent(getApplicationContext(), sudongmenu.class);
        startActivity(intent1);
    }


    public void Auto_btnClicked (View view){
        Intent intent5 = new Intent(getApplicationContext(), Automenu.class);
        startActivity(intent5);
    }

    public void Train_btnClicked (View view){
        Intent intent3 = new Intent(getApplicationContext(), Trainmenu.class);
        startActivity(intent3);
    }


    public void onBackButtonClicked (View view){
        Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_LONG).show();
        finish();
    }


    public void Newhand(View view) {
        Intent intent4 = new Intent(getApplicationContext(), Firstpage.class);
        startActivity(intent4);
    }

    public void graphclick(View view) {
        Intent intent2 = new Intent(this, recycler_main.class);
        startActivity(intent2);
    }

    public void start_stop_onClick(View view) {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);
    }

}
