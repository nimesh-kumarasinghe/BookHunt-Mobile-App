package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Signin : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var txt_forgot_pwd = findViewById<TextView>(R.id.txt_forgot_pw)
        var txt_sign_up = findViewById<TextView>(R.id.txt_dont_have_anaccount)
        var btn_b= findViewById<Button>(R.id.btn_sign_in_btn)

        txt_forgot_pwd.setOnClickListener()
        {
            var forgot_password = Intent(this@Signin, ForgotPassword::class.java)
            startActivity(forgot_password)
        }

        txt_sign_up.setOnClickListener()
        {
            var sign_up_intent = Intent(this@Signin, Signup::class.java)
            startActivity(sign_up_intent)
        }




        btn_b.setOnClickListener()
        {
            var bynw = Intent(this@Signin, BookItem::class.java)
            startActivity(bynw)
        }








    }
}