package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()

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