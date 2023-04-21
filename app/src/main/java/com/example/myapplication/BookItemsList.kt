package com.example.myapplication


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.View.inflate
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookItemsList : AppCompatActivity() {
    private lateinit var adapter: BookAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookItemsArrayList: ArrayList<Books>

    lateinit var imgId : Array<Int>
    lateinit var bkname : Array<String>
    lateinit var author : Array<String>
    lateinit var price : Array<String>
    lateinit var rbar : Array<Float>
    lateinit var bookDescr : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_items_list)

        supportActionBar?.hide()


        var back = findViewById<ImageButton>(R.id.back_arrow_imgbtn)

        back.setOnClickListener(){
            onBackPressed()
        }


        dataInitialize()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        adapter = BookAdapter(bookItemsArrayList)
        recyclerView.adapter = adapter
        //newArrayList = arrayListOf<Books>()
    }

    private fun dataInitialize() {
        bookItemsArrayList = arrayListOf<Books>()
        imgId = arrayOf(
            R.drawable.book1,
            R.drawable.book2,
            R.drawable.book3,
            R.drawable.book1,
        )
        bkname = arrayOf(
            "The Heart of Hell",
            "Adrennes 1944",
            "War on the Gothic Line",
            "The Heart of Hell"
        )

        author = arrayOf(
            "Mitch Weiss",
            "Antony Beevor",
            "The Heart of Hell",
            "Christian Jennings"
        )
        price = arrayOf(
            "500 LKR",
            "500 LKR",
            "500 LKR",
            "500 LKR"

        )

        rbar = arrayOf(
            4.0f,
            4.0f,
            4.0f,
            4.0f
        )

        bookDescr = arrayOf(
            "The untold story of courage and sacrifice in the shadow of Iwo Jima.",
            "#1 international bestseller and award winning history book.",
            "Through the eyes of thirteen men and women from seven different nations",
            "The untold story of courage and sacrifice in the shadow of Iwo Jima."
        )
        for (i in imgId.indices){
            val info = Books(imgId[i],bkname[i],author[i],price[i],rbar[i],bookDescr[i])
            bookItemsArrayList.add(info)
        }
    }
}