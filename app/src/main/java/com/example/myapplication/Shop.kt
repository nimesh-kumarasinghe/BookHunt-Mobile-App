package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Shop : AppCompatActivity() {

    private lateinit var adapter: BookStoreAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var storeArrayList: ArrayList<BookStore>

    lateinit var storeImage : Array<Int>
    lateinit var storeName : Array<String>
    lateinit var storeAddress : Array<String>
    lateinit var storeTelephone : Array<String>
    lateinit var storeEmail : Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        supportActionBar?.hide()

        var back = findViewById<ImageButton>(R.id.btn_store_back)

        back.setOnClickListener() {
            onBackPressed()
        }

        dataInitialize()

        recyclerView = findViewById(R.id.recycler_view_stores)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        adapter = BookStoreAdapter(storeArrayList)
        recyclerView.adapter = adapter

    }
    private fun dataInitialize() {
        storeArrayList = arrayListOf<BookStore>()
        storeImage = arrayOf(
            R.drawable.user_image,
            R.drawable.user_image,
            R.drawable.user_image,
            R.drawable.user_image,
            R.drawable.user_image
        )
        storeName = arrayOf(
            "Shop Name",
            "Shop Name",
            "Shop Name",
            "Shop Name",
            "Shop Name"
        )
        storeAddress = arrayOf(
            "Shop Address",
            "Shop Address",
            "Shop Address",
            "Shop Address",
            "Shop Address"

        )
        storeTelephone = arrayOf(
            "Shop Telephone",
            "Shop Telephone",
            "Shop Telephone",
            "Shop Telephone",
            "Shop Telephone"
        )
        storeEmail = arrayOf(
            "Shop Email",
            "Shop Email",
            "Shop Email",
            "Shop Email",
            "Shop Email"
        )

        for (i in storeImage.indices){
            val info = BookStore(storeImage[i],storeName[i],storeAddress[i],storeTelephone[i],storeEmail[i])
            storeArrayList.add(info)
        }
    }
}