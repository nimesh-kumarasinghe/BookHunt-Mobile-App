package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class FindNearestStore : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_nearest_store)
        supportActionBar?.hide()

      var near_btn= findViewById<Button>(R.id.btn_proceed)
      var back = findViewById<ImageButton>(R.id.btnn_back_button)


        back.setOnClickListener(){
            onBackPressed()
        }
        near_btn.setOnClickListener()
        {
            var intent_btn = Intent(this@FindNearestStore, Shop::class.java)
            startActivity(intent_btn)
        }


    }
}