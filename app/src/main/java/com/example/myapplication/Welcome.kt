package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("customer_data_sv", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLogin", false)

        if (isLoggedIn == true) {
            var bynw = Intent(this@Welcome, HomeScreen::class.java)
            startActivity(bynw)
        }

        var btn_signin= findViewById<Button>(R.id.btn_signin)
        var btn_creat_acc = findViewById<Button>(R.id.btn_create_acc)

        btn_signin.setOnClickListener()
        {
            var sign_in = Intent(this@Welcome, Signin::class.java)
            startActivity(sign_in)
        }
        btn_creat_acc.setOnClickListener()
        {
            var creat_acc = Intent(this@Welcome, Signup::class.java)
            startActivity(creat_acc)
        }




    }





}