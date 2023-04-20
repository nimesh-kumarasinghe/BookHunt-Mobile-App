package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SuccessfullPayment : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successfull_payment)

        var successfull_txtView= findViewById<TextView>(R.id.txt_continue_tx)


       successfull_txtView.setOnClickListener()
        {
            var success_pay= Intent(this@SuccessfullPayment, EditProfile::class.java)
            startActivity(success_pay)
        }


    }
}