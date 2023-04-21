package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PublishReview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish_review)

        var see_reviews= findViewById<Button>(R.id.btn_publish)


        see_reviews.setOnClickListener()
        {
            var intentbtn = Intent(this@PublishReview, BookReviews::class.java)
            startActivity(intentbtn)
        }



    }
}