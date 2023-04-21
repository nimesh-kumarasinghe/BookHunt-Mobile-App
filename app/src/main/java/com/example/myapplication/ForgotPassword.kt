package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.hide()

        var btn_send_otp= findViewById<Button>(R.id.btn_sendOtp)

        var btn_back = findViewById<ImageButton>(R.id.btn_bback_arrow)

        btn_back.setOnClickListener()
        {
            onBackPressed()
        }

        btn_send_otp.setOnClickListener()
        {
            var send_otp = Intent(this@ForgotPassword, OtpPage::class.java)
            startActivity(send_otp)
        }


    }
}