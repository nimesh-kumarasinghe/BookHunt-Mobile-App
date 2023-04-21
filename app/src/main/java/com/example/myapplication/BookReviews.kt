package com.example.myapplication

//import android.annotation.SuppressLint
import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookReviews : AppCompatActivity() {

    private lateinit var adapter: ReviewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var reviewArrayList: ArrayList<Review>

    lateinit var bookName : Array<String>
    lateinit var comment : Array<String>
    lateinit var rating : Array<Float>


    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_reviews)

        supportActionBar?.hide()


        var back = findViewById<ImageButton>(R.id.imgBtn_back)

        back.setOnClickListener() {
            onBackPressed()
        }

        dataInitialize()

        recyclerView = findViewById(R.id.recycler_view_reviews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        adapter = ReviewAdapter(reviewArrayList)
        recyclerView.adapter = adapter
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType")
    private fun dataInitialize() {
        reviewArrayList = arrayListOf<Review>()
        bookName = arrayOf(
            "Mitch Weiss",
            "Antony Beevor",
            "The Heart of Hell",
            "Christian Jennings"
        )
        comment = arrayOf(
            getString(R.string.review_comment),
            getString(R.string.review_comment),
            getString(R.string.review_comment),
            getString(R.string.review_comment)

        )

        rating = arrayOf(
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating)
        )

        for (i in bookName.indices){
            val info = Review(bookName[i],comment[i],rating[i])
            reviewArrayList.add(info)
        }
    }


}

