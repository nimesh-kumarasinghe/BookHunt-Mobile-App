package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PublishReview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish_review)
        supportActionBar?.hide()

        var see_reviews= findViewById<Button>(R.id.btn_publish)
        var back = findViewById<ImageButton>(R.id.button_arow)

        back.setOnClickListener(){
            onBackPressed()
        }


        see_reviews.setOnClickListener()
        {

        }



    }
}