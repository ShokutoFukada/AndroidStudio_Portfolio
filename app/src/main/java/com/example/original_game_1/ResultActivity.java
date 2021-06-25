package com.example.original_game_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    //終わるボタン
    Button button_finish;
    //結果
    String result;
    //計測時間
    TextView timerText_result;
    //評価
    TextView textView_Result03;
    //電子レンジからのメッセージ
    TextView microwave_text;
    // データの受け取り
    String result_time = "00 : 00";
    Data get_d;
    //秒数の受け取り
    int data_time;
    Data get_seconds_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //終わるボタンの生成
        button_finish = findViewById(R.id.btn_finish);
        button_finish.setOnClickListener(this);

        //インテントの受け取り
        Intent intent = getIntent();
        result = intent.getStringExtra("result");

        // 経過時間の受け取り
        get_d = (Data)this.getApplication();
        result_time = get_d.getTime();

        //秒数の受け取り
        get_seconds_d = (Data)this.getApplication();
        data_time = get_seconds_d.getSeconds_time();
        //評価
        textView_Result03 = findViewById(R.id.textView_Result03);
        //電子レンジからのメッセージ
        microwave_text = findViewById(R.id.microwave_text);
        //タイマーの結果
        timerText_result = findViewById(R.id.timerText_Result);
        timerText_result.setText(result_time);
        //judgeメソッド
        judge();

    }


    @Override
    public void onClick(View v) {
        this.finish();
        this.moveTaskToBack(true);  //アプリの終了
    }

    public  void judge(){

        int a = data_time;

        switch (result){
            case "1":   //おにぎりの場合
                if(a == 30){
                    textView_Result03.setText("◎");
                    microwave_text.setText(R.string.text_message01);
                }else if (25 <= a && a <= 29) {
                    textView_Result03.setText("〇");
                    microwave_text.setText(R.string.text_message02);
                }else if (20 <= a && a <= 25){
                    textView_Result03.setText("△");
                    microwave_text.setText(R.string.text_message03);
                }else if (a <= 20){
                    textView_Result03.setText("✕");
                    microwave_text.setText(R.string.text_message04);
                }else {
                    textView_Result03.setText("✕");
                    microwave_text.setText(R.string.text_message05);
                }
                break;

            case "2":   //たまごの場合
                if(a == 10){
                    textView_Result03.setText("◎");
                    microwave_text.setText(R.string.text_message01);
                }else if (5 <= a && a <= 9) {
                    textView_Result03.setText("〇");
                    microwave_text.setText(R.string.text_message02);
                }else if (2 <= a && a <= 4){
                    textView_Result03.setText("△");
                    microwave_text.setText(R.string.text_message03);
                }else {
                    textView_Result03.setText("✕");
                    microwave_text.setText(R.string.text_message05);
                }
                break;
            case "3":   //冷凍食品
                if(a == 100){
                    textView_Result03.setText("◎");
                    microwave_text.setText(R.string.text_message01);
                }else if (80 <= a && a <= 99) {
                    textView_Result03.setText("〇");
                    microwave_text.setText(R.string.text_message02);
                }else if (40 <= a && a <= 79){
                    textView_Result03.setText("△");
                    microwave_text.setText(R.string.text_message03);
                }else if (a <= 40){
                    textView_Result03.setText("✕");
                    microwave_text.setText(R.string.text_message04);
                }else {
                    textView_Result03.setText("✕");
                    microwave_text.setText(R.string.text_message05);
                }
                break;
        }
    }
}