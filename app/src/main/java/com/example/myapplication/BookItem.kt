package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

    lateinit var price_x: String

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_item)
        supportActionBar?.hide()

        var intent = intent
        book_id = intent.getStringExtra("book_id").toString()

        val sharedPref = getSharedPreferences("customer_data_sv", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)
        val customer_id = sharedPref.getString("logged", null)

        val btn_buyre = findViewById<Button>(R.id.btn_buy_nw_item)
        val btn_plus = findViewById<Button>(R.id.button_plus)
        val btn_minus = findViewById<Button>(R.id.button_minus)
        val bk_quantity = findViewById<TextView>(R.id.txt_quantity)
        var btn_back = findViewById<ImageButton>(R.id.imgBtn_back_item)
        var transparency = findViewById<ImageView>(R.id.transparency)
        //var cart = findViewById<Button>(R.id.btn_add_to_cart_item)

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


        btn_buyre.setOnClickListener() // buy  now
        {
            val currentDate = LocalDate.now()
            val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yy-MM-dd"))

            val jsonObject = JSONObject()
            jsonObject.put("OrderDate", formattedDate)
            jsonObject.put("OrderStatus", "Pending")
            jsonObject.put("PaymentStatus", "Pending Payment")
            jsonObject.put(
                "TotalAmount",
                (price_x.toDouble() * bk_quantity.text.toString().toInt())
            )
            jsonObject.put("customer_id", customer_id.toString())

            val queue = Volley.newRequestQueue(this.applicationContext)

            val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,
                "https://api.icodingx.com/bookhunt/orders/",
                jsonObject,
                { response ->

                    val order_book = JSONObject()
                    jsonObject.put("book_id", book_id.toString())
                    jsonObject.put("order_id", response.getString("OrderID"))
                    jsonObject.put("quantity", bk_quantity.text.toString())


                    val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,
                        "https://api.icodingx.com/bookhunt/order-books/",
                        jsonObject,
                        { res ->
                            Toast.makeText(
                                applicationContext, "Order Placed",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        { error ->
                            // Handle errors here
                        })

                    queue.add(jsonObjectRequest)
                },
                { error ->
                    // Handle errors here
                })

            queue.add(jsonObjectRequest)
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
                txt_book_category.setText("Category: " + response.getString("CategoryName")) //SET TITLES IF NEEDED
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
                txt_book_author.setText("By " + response.getString("Author"))
                txt_book_price.setText(response.getString("Price") + "LKR")
                price_x = response.getString("Price")
                txt_book_pub_date.setText("Publication date: " + response.getString("PublicationDate"))
                txt_book_isbn.setText("ISBN: " + response.getString("ISBN"))
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
