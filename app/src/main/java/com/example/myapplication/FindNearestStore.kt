package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FindNearestStore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_nearest_store)

      var near_btn= findViewById<Button>(R.id.btn_proceed)


        near_btn.setOnClickListener()
        {
            var intent_btn = Intent(this@FindNearestStore, OrderDetails::class.java)
            startActivity(intent_btn)
        }


    }
}