package com.example.original_game_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンの生成
        Button button = findViewById(R.id.button_main);
        //ボタンをタップすると次の画面へ遷移
        button.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),SubActivity.class));
            finish();
        });
    }
}