package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        var txt_already_acc = findViewById<TextView>(R.id.txt_already_have_an_account)

        txt_already_acc.setOnClickListener()
        {
            var already_acc = Intent(this@Signup, Signin::class.java)
            startActivity(already_acc)
        }

        var btnc= findViewById<Button>(R.id.btn_signup)

        btnc.setOnClickListener()
        {
            var bb = Intent(this@Signup, Signin::class.java)
            startActivity(bb)
        }

    }
}