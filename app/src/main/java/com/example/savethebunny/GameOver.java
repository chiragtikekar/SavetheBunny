package com.example.savethebunny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class GameOver extends AppCompatActivity {

    TextView tvPoints;
    TextView tvHighest;
    SharedPreferences sharedPreferences;
    ImageView ivNewHigheat;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        tvPoints = findViewById(R.id.tvPoints);
        tvHighest = findViewById(R.id.tvHighest);
        ivNewHigheat = findViewById(R.id.ivNewHighest);
        int points = getIntent().getExtras().getInt("points");
        tvPoints.setText(""+ points);
        sharedPreferences = getSharedPreferences("my_pref",0);
        int higtest = sharedPreferences.getInt("highest",0);
        if(points > higtest){
            ivNewHigheat.setVisibility(View.VISIBLE);
            higtest = points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest", higtest);
            editor.commit();
        }
        tvHighest.setText("" + higtest);
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void stop(View view){
        finish();
    }
}