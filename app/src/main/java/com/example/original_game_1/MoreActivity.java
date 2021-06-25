package com.example.original_game_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.AnimationUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    TextView timerText;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;

    int timer_judge = 0;

    String text;
    String text_time;
    String time_str;

    Button button_start;
    Button button_stop;

    //時間の保存
    Data d;
    //秒数の保存
    Data seconds_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        //インテントの受け取り
        Intent intent = getIntent();
        text = intent.getStringExtra("request");

        //始めるボタンの生成
        button_start = findViewById(R.id.button_more_start);
        button_start.setOnClickListener(this);
        //止めるボタンの生成
        button_stop = findViewById(R.id.button_more_stop);
        button_stop.setOnClickListener(this);

        timer = new Timer();

        timerText = findViewById(R.id.timerText);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_more_start:

                timer_judge = 0;
                startStopTapped();
                findViewById(R.id.imageView_more).startAnimation(AnimationUtils.loadAnimation(this,R.anim.animation));
                Toast.makeText(MoreActivity.this, "温め中....", Toast.LENGTH_LONG).show();

                break;
            case R.id.button_more_stop:

                //インテントの生成
                Intent intent = new
                        Intent(getApplicationContext(),ResultActivity.class);

                //評価の基準となる秒数をセット
                int seconds_time = Integer.parseInt(time_str);

                switch (text){
                    case "1":

                        //タイマーを止める
                        timer_judge = 1;
                        startStopTapped();
                        text_time = getTimerText();
                        //経過時間をセット
                        d = (Data)this.getApplication();
                        d.setTime(text_time);
                        //評価の基準となる秒数をセット
                        seconds_d = (Data)this.getApplication();
                        seconds_d.setSeconds_time(seconds_time);
                        //アニメーションの停止
                        findViewById(R.id.imageView_more).clearAnimation();
                        //画面遷移開始
                        intent.putExtra("result","1");
                        startActivity(intent);
                        break;

                    case "2":

                        //タイマーを止める
                        timer_judge = 1;
                        startStopTapped();
                        text_time = getTimerText();
                        //経過時間をセット
                        d = (Data)this.getApplication();
                        d.setTime(text_time);
                        //評価の基準となる秒数をセット
                        seconds_d = (Data)this.getApplication();
                        seconds_d.setSeconds_time(seconds_time);
                        //アニメーションの停止
                        findViewById(R.id.imageView_more).clearAnimation();
                        //画面遷移開始
                        intent.putExtra("result","2");
                        startActivity(intent);
                        break;

                    case "3":

                        //タイマーを止める
                        timer_judge = 1;
                        startStopTapped();
                        text_time = getTimerText();
                        //経過時間をセット
                        d = (Data)this.getApplication();
                        d.setTime(text_time);
                        //評価の基準となる秒数をセット
                        seconds_d = (Data)this.getApplication();
                        seconds_d.setSeconds_time(seconds_time);
                        //アニメーションの停止
                        findViewById(R.id.imageView_more).clearAnimation();
                        //画面遷移開始
                        intent.putExtra("result","3");
                        startActivity(intent);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + text);
                }

                finish();
                break;
        }
    }

    public void startStopTapped()
    {
        if(timer_judge == 0)
        {
            timer_judge = 1;
            startTimer();
        }
        else
        {
            timer_judge = 0;
            timerTask.cancel();
        }
    }

    public void startTimer()
    {
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                runOnUiThread(() -> {
                    time++;
                    timerText.setText(getTimerText());
                });
            }

        };
        timer.scheduleAtFixedRate(timerTask, 0 ,1000);
    }

    public String getTimerText()
    {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        //分を秒に変更して秒と合わせる
        int minute_seconds = minutes * 60;
        int total_seconds = minute_seconds + seconds;

        time_str = String.valueOf(total_seconds);//秒数のタイムを代入
        return formatTime(seconds, minutes);

    }

    @SuppressLint("DefaultLocale")
    public String formatTime(int seconds, int minutes)
    {
        return String.format("%02d",minutes) + " : " + String.format("%02d",seconds);
    }
}