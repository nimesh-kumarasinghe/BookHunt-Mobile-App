package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class CheckoutPay : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_pay)

        supportActionBar!!.hide()

        var intentx = intent
        var order_id = intentx.getStringExtra("order_id")

        var payment_link = findViewById<WebView>(R.id.webView_checkout)

        payment_link.settings.javaScriptEnabled = true

        val queue = Volley.newRequestQueue(this.applicationContext)

        payment_link.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url?.startsWith("https://api.icodingx.com/bookhunt/payments/") == true) {
                    // Payment was successful, handle the response here
                    // ...
                    Toast.makeText(
                        applicationContext, "Payment was successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    onBackPressed() // Go back to the app
                    return true // Return true to indicate that the URL was handled
                }
                return super.shouldOverrideUrlLoading(view, url)
            }
        }

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/pay/?OrderID=${order_id}",
            null,
            { response ->
                payment_link.loadUrl(response.getString("Payment_Link"))


            },
            { error ->
                // Handle errors here
            })


        queue.add(jsonObjectRequest)

        var back = findViewById<ImageButton>(R.id.btn_back_back_btn)


        back.setOnClickListener()
        {
            onBackPressed()
        }
    }
}