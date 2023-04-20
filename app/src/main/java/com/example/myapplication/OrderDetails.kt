package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        var order_rev_btn= findViewById<Button>(R.id.btn_add_review)


        order_rev_btn.setOnClickListener()
        {
            var intentbtn = Intent(this@OrderDetails, PublishReview::class.java)
            startActivity(intentbtn)
        }
    }
}