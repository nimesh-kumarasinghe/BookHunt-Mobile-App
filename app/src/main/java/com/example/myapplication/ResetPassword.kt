package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ResetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        var btn_reset_pwd= findViewById<Button>(R.id.btn_reset)
        var btn_img= findViewById<ImageButton>(R.id.back_button_button)


        btn_reset_pwd.setOnClickListener()
        {
            var reset_pwd = Intent(this@ResetPassword, Success::class.java)
            startActivity(reset_pwd)
        }

        btn_img.setOnClickListener()
        {
            var back_btn_img = Intent(this@ResetPassword, ForgotPassword::class.java)
            startActivity(back_btn_img)
        }
    }
}