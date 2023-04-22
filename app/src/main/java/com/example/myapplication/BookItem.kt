package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class BookItem : AppCompatActivity() {

    private var quantity = 1


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_item)
        supportActionBar?.hide()

        var intent = intent
        var book_id = intent.getStringExtra("book_id")

        val btn_buyre = findViewById<Button>(R.id.btn_buy_nw_item)
        val btn_plus = findViewById<Button>(R.id.button_plus)
        val btn_minus = findViewById<Button>(R.id.button_minus)
        val bk_quantity = findViewById<TextView>(R.id.txt_quantity)
        var btn_back = findViewById<ImageButton>(R.id.imgBtn_back_item)
        var transparency = findViewById<ImageView>(R.id.transparency)
        var cart = findViewById<Button>(R.id.btn_add_to_cart_item)


        var txt_book_name = findViewById<TextView>(R.id.txt_book_name)
        var txt_book_author = findViewById<TextView>(R.id.txt_author)
        var txt_book_pub_date = findViewById<TextView>(R.id.txt_publication_date)
        var txt_book_desc = findViewById<TextView>(R.id.txt_description)
        var txt_book_price = findViewById<TextView>(R.id.txt_price_txt)
        var txt_book_isbn = findViewById<TextView>(R.id.txt_ISBNno)
        var txt_book_category = findViewById<TextView>(R.id.txt_category)

        transparency.setOnClickListener(){
            var ratings = Intent(this@BookItem, BookReviews::class.java)
            startActivity(ratings)
        }


        btn_back.setOnClickListener()
        {
            onBackPressed()
        }


        btn_buyre.setOnClickListener()
        {

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
    fun loadBookData(onSuccess: (JSONObject) -> Unit){
//        val queue = Volley.newRequestQueue(this.applicationContext)
//        val url = ""
//
//        val jsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET, url,
//            { response ->
//                // Handle the response data here
//            },
//            { error ->
//                // Handle errors here
//            })
//        queue.add(jsonObjectRequest)
    }

}
