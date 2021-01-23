package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        var tv_Name = findViewById<TextView>(R.id.tv_name)
        tv_Name.text = username

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        if(correctAnswer>5){
        var tv_Score = findViewById<TextView>(R.id.tv_score)
        tv_Score.text = "Nilai benar anda $correctAnswer dari $totalQuestion!"
        }else {
            var tv_Score = findViewById<TextView>(R.id.tv_score)
            tv_Score.text = "Anda Gagal"
        }



        var btn_Finish = findViewById<Button>(R.id.btn_finish)
        btn_Finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}