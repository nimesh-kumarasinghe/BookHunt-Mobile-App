package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Shop : AppCompatActivity() {

    private lateinit var adapter: BookStoreAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var storeArrayList: ArrayList<BookStore>

    lateinit var storeImage: String
    lateinit var storeName: String
    lateinit var storeAddress: String
    lateinit var storeTelephone: String
    lateinit var storeEmail: String

    lateinit var user_lat: String
    lateinit var user_long: String
    lateinit var sh_keyword: String


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        supportActionBar?.hide()

        var back = findViewById<ImageButton>(R.id.btn_store_back)

        back.setOnClickListener() {
            onBackPressed()
        }

        val intentx = intent
        user_lat = intentx.getStringExtra("user_lat").toString()
        user_long = intentx.getStringExtra("user_long").toString()
        sh_keyword = intentx.getStringExtra("sh_keyword").toString()


        storeArrayList = arrayListOf<BookStore>()
        loadData()
    }

    private fun getSellerData(seller_id: Int, onSuccess: (JSONObject) -> Unit) {

        val queue = Volley.newRequestQueue(this.applicationContext)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/sellers/" + seller_id.toString(),
            null,
            { response ->
                onSuccess(response)
                // Use the response data here
            },
            { error ->
                // Handle errors here
            })

        queue.add(jsonObjectRequest)


    }

    private fun sellerInfoLoad(distance: JSONArray, onSuccess: (dt: Int) -> Unit) {
        var item_count = distance.length()
        var count = 0
        for (x in 0 until distance.length()) {
            val dt_x = distance.getJSONObject(x)
            getSellerData(dt_x.getString("seller").toInt()) { res ->
                storeImage = res.getString("ProfilePicture")
                storeName = res.getString("ShopName")
                storeAddress =
                    res.getString("AddressNo") + res.getString("Street") + res.getString("City")
                storeTelephone = res.getString("PhoneNo")
                storeEmail = res.getString("Email")

                val dt = BookStore(
                    storeImage,
                    storeName,
                    storeAddress,
                    storeTelephone,
                    storeEmail
                )
                storeArrayList.add(dt)
                //Log.e("xxx",store_x.toString())

                count++
                if (count == item_count) {
                    onSuccess(1)
                }
            }
        }
    }

    private fun loadData() {

        val queue = Volley.newRequestQueue(this.applicationContext)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "https://api.icodingx.com/bookhunt/nearest-stores/?latitude=${user_lat}&longitude=${user_long}&keyword=${sh_keyword}",
            null,
            { response ->
                val distances = response.getJSONArray("distance")

                sellerInfoLoad(distances) {
                    recyclerView = findViewById(R.id.recycler_view_stores)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.setHasFixedSize(true)
                    adapter = BookStoreAdapter(storeArrayList)
                    recyclerView.adapter = adapter
                }
                // Use the response data here
            },
            { error ->
                // Handle errors here
            })

        queue.add(jsonObjectRequest)
    }
}