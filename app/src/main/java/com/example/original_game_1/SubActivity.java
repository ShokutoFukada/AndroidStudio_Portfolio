package com.example.original_game_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //イメージボタンの生成(おにぎり)
        final ImageButton imageButton_oni = findViewById(R.id.imageButton_oni);
        imageButton_oni.setOnClickListener(this);
        //イメージボタンの生成(たまご)
        final ImageButton imageButton_tama = findViewById(R.id.imageButton_tama);
        imageButton_tama.setOnClickListener(this);
        //イメージボタンの生成(冷凍食品)
        final ImageButton imageButton_rei = findViewById(R.id.imageButton_rei);
        imageButton_rei.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        Intent intent = new
                Intent(getApplicationContext(),MoreActivity.class);

        switch (v.getId()){
            case R.id.imageButton_oni:
                Toast.makeText(SubActivity.this, "おにぎりにしました", Toast.LENGTH_SHORT).show();
                intent.putExtra("request","1");
                startActivity(intent);
                break;

            case R.id.imageButton_tama:
                intent.putExtra("request","2");
                Toast.makeText(SubActivity.this, "たまごにしました", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.imageButton_rei:
                intent.putExtra("request","3");
                Toast.makeText(SubActivity.this, "冷凍食品にしました", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
        }
        finish();
    }
}