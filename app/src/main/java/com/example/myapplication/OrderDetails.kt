package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class OrderDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        supportActionBar?.hide()

        var intent = intent
        var order_id = intent.getStringExtra("order_id").toString()

        var order_rev_btn = findViewById<Button>(R.id.btn_add_review)
        var back = findViewById<ImageButton>(R.id.button_arrow)
        var buyNow = findViewById<Button>(R.id.btn_buy_now)

//        var book_name = findViewById<TextView>(R.id./txt_book_name)
        var order_no = findViewById<TextView>(R.id.txt_order_no)
        var order_date = findViewById<TextView>(R.id.txt_order_date)
        var status = findViewById<TextView>(R.id.order_details_txtView5)
//        var txt_qty = findViewById<TextView>(R.id.txt_qty)
        var total = findViewById<TextView>(R.id.order_details_txtView7)

        val queue = Volley.newRequestQueue(this.applicationContext)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/orders/${order_id}",
            null,
            { response ->
                //book_name.setText("Book Name:" +response.getString(""))
                order_no.setText("Order No: " + response.getString("OrderID"))
                order_date.setText("Order Date: " + response.getString("OrderDate"))
                status.setText("Status: " + response.getString("OrderStatus"))
                //txt_qty.setText("QTY:" + response.getString(""))
                total.setText("Total Amount: " + response.getString("TotalAmount"))

                if (response.getString("OrderStatus") == "Accepted") {
                    order_rev_btn.setOnClickListener()
                    {
                        var intentbtn = Intent(this@OrderDetails, PublishReview::class.java)
                        startActivity(intentbtn)
                    }

                    buyNow.setOnClickListener() {
                        var intentbtn = Intent(this@OrderDetails, CheckoutPay::class.java)
                        intentbtn.putExtra("order_id", response.getString("OrderID"))
                        startActivity(intentbtn)
                    }
                }
            },
            { error ->
                // Handle errors here
            })

        queue.add(jsonObjectRequest)

        back.setOnClickListener() {
            onBackPressed()
        }


    }

}