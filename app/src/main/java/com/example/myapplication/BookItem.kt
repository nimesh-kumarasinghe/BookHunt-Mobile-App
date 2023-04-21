package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BookItem : AppCompatActivity() {

    private var quantity = 1


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_item)

        val btn_buyre = findViewById<Button>(R.id.btn_buy_nw_item)
        val btn_plus = findViewById<Button>(R.id.button_plus)
        val btn_minus = findViewById<Button>(R.id.button_minus)
        val bk_quantity = findViewById<TextView>(R.id.txt_quantity)


        btn_buyre.setOnClickListener()
        {
            var bynwr = Intent(this@BookItem, CheckoutMethod::class.java)
            startActivity(bynwr)
        }

        btn_plus.setOnClickListener {
            quantity++
            bk_quantity.text = quantity.toString()
        }

        btn_minus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                bk_quantity.text = quantity.toString()
            }
        }

    }
}