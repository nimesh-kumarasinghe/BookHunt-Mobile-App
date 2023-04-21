package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class OtpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_page)
        supportActionBar?.hide()

        var btn_verfy= findViewById<Button>(R.id.btn_verify)
        var btn_img= findViewById<ImageButton>(R.id.btn_back_arr)


        btn_verfy.setOnClickListener()
        {
            var otp_verify = Intent(this@OtpPage, ResetPassword::class.java)
            startActivity(otp_verify)
        }

        btn_img.setOnClickListener()
        {
            onBackPressed()
        }
    }
}