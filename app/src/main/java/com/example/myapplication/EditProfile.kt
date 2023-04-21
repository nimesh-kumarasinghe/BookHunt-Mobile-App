package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        supportActionBar?.hide()

        var back = findViewById<ImageButton>(R.id.btn_back_back)
        var editPhoto = findViewById<Button>(R.id.btn_edit_photo)
        var save = findViewById<Button>(R.id.button_save)

        back.setOnClickListener(){
            onBackPressed()
        }

        editPhoto.setOnClickListener(){

        }

        save.setOnClickListener(){

        }






    }
}