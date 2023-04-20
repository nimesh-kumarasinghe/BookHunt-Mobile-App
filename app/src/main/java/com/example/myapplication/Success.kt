package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Success : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        var success_txtView= findViewById<TextView>(R.id.txt_continue)


        success_txtView.setOnClickListener()
        {
            var succ_txtView = Intent(this@Success, FindNearestStore::class.java)
            startActivity(succ_txtView)
        }


    }
}