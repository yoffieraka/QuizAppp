package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tombol = findViewById<Button>(R.id.btn_start)
        var ET_name = findViewById<EditText>(R.id.et_name)
        tombol.setOnClickListener(View.OnClickListener {
            if(ET_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Mohon Masukkan Nama", Toast.LENGTH_SHORT).show()
            }else{var intent = Intent (this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,ET_name.text.toString())
                startActivity(intent)}
                finish()
        })
    }
}