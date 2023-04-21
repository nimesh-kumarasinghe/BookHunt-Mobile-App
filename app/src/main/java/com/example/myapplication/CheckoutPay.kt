package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CheckoutPay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_pay)

        supportActionBar!!.hide()

        var back= findViewById<ImageButton>(R.id.btn_back_back_btn)


        back.setOnClickListener()
        {
            onBackPressed()
        }
    }
}