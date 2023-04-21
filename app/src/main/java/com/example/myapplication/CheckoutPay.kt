package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CheckoutPay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_pay)

        var pay_btn= findViewById<Button>(R.id.btn_pay)


        pay_btn.setOnClickListener()
        {
            var intent_pay = Intent(this@CheckoutPay, SuccessfullPayment::class.java)
            startActivity(intent_pay)
        }
    }
}