package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        supportActionBar?.hide()

        var order_rev_btn= findViewById<Button>(R.id.btn_add_review)
        var back = findViewById<ImageButton>(R.id.button_arrow)
        var buyNow = findViewById<Button>(R.id.btn_buy_now)

        back.setOnClickListener(){
            onBackPressed()
        }


        order_rev_btn.setOnClickListener()
        {
            var intentbtn = Intent(this@OrderDetails, PublishReview::class.java)
            startActivity(intentbtn)
        }

        buyNow.setOnClickListener(){
            var intentbtn = Intent(this@OrderDetails, CheckoutPay::class.java)
            startActivity(intentbtn)
        }
    }
}