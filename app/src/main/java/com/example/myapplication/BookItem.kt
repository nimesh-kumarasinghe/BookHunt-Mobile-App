package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject

class BookItem : AppCompatActivity() {

    private var quantity = 1
    lateinit var book_id: String

    lateinit var txt_book_name: TextView
    lateinit var txt_book_author: TextView
    lateinit var txt_book_pub_date: TextView
    lateinit var txt_book_desc: TextView
    lateinit var txt_book_price: TextView
    lateinit var txt_book_isbn: TextView
    lateinit var txt_book_category: TextView
    lateinit var pro_img: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_item)
        supportActionBar?.hide()

        var intent = intent
        book_id = intent.getStringExtra("book_id").toString()

        val btn_buyre = findViewById<Button>(R.id.btn_buy_nw_item)
        val btn_plus = findViewById<Button>(R.id.button_plus)
        val btn_minus = findViewById<Button>(R.id.button_minus)
        val bk_quantity = findViewById<TextView>(R.id.txt_quantity)
        var btn_back = findViewById<ImageButton>(R.id.imgBtn_back_item)
        var transparency = findViewById<ImageView>(R.id.transparency)
        var cart = findViewById<Button>(R.id.btn_add_to_cart_item)

        txt_book_name = findViewById(R.id.txt_book_name_x)
        txt_book_author = findViewById(R.id.txt_author)
        txt_book_pub_date = findViewById(R.id.txt_publication_date)
        txt_book_desc = findViewById(R.id.txt_description)
        txt_book_price = findViewById(R.id.txt_price_txt)
        txt_book_isbn = findViewById(R.id.txt_ISBNno)
        txt_book_category = findViewById(R.id.txt_category)

        pro_img = findViewById(R.id.img_book_item_image)

        loadBookData() { i ->
        }

        transparency.setOnClickListener() {
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

    fun getCateName(id: String) {
        val queue = Volley.newRequestQueue(this.applicationContext)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/categories/${id}",
            null,
            { response ->
                txt_book_category.setText("Category: "+response.getString("CategoryName")) //SET TITLES IF NEEDED
            },
            { error ->
                // Handle errors here
            })

        queue.add(jsonObjectRequest)
    }

    fun loadBookData(onSuccess: (JSONObject) -> Unit) {
        val queue = Volley.newRequestQueue(this.applicationContext)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/books/${book_id}",
            null,
            { response ->
                Log.e("X", response.toString())
                txt_book_name.setText(response.getString("Title"))  //SET TITLES IF NEEDED
                txt_book_author.setText("By "+response.getString("Author"))
                txt_book_price.setText(response.getString("Price")+"LKR")
                txt_book_pub_date.setText("Publication date: "+response.getString("PublicationDate"))
                txt_book_isbn.setText("ISBN: "+response.getString("ISBN"))
                txt_book_desc.setText(response.getString("BDescription"))
                getCateName(response.getString("category_id"))

                Glide.with(pro_img)
                    .load(response.getString("imgLocation"))
                    .into(pro_img);
            },
            { error ->
                // Handle errors here
            })

        queue.add(jsonObjectRequest)
    }

}
