package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CheckoutMethod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_method)

        var ch_btn= findViewById<Button>(R.id.btn_confirm_order)


        ch_btn.setOnClickListener()
        {
            var intent_cpay = Intent(this@CheckoutMethod, CheckoutPay::class.java)
            startActivity(intent_cpay)
        }

    }
}