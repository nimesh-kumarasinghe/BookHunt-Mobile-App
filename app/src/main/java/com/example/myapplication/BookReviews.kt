package com.example.myapplication

//import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookReviews : AppCompatActivity() {

    private lateinit var NewRecylerview : RecyclerView
    private lateinit var NewArrayList: ArrayList<Reviews>
    lateinit var uname : Array<String>
    lateinit var bktitle : Array<String>
    lateinit var revieww : Array<String>
    lateinit var revwbar : Array<Float>

    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_reviews)


        uname = arrayOf(
            "Mitch Weiss",
            "Antony Beevor",
            "The Heart of Hell",
            "Christian Jennings"
        )

        bktitle = arrayOf(
            "The Heart of Hell",
            "War on the Gothic Line",
            "The Heart of Hell",
            "The Heart of Hell"
        )

        revieww = arrayOf(
            "Mitch Weiss",
            "Antony Beevor",
            "The Heart of Hell",
            "Christian Jennings"
        )



        NewRecylerview = findViewById(R.id.recyclerViewReview)
        NewRecylerview.layoutManager = LinearLayoutManager(this)
        NewRecylerview.setHasFixedSize(true)

        NewArrayList = arrayListOf<Reviews>()
        getUserdata()

    }

    private fun getUserdata() {


        for (i in uname.indices){
            val info = Reviews(uname[i],bktitle[i],revieww[i],revwbar[i])
            NewArrayList.add(info)
        }
        val adapter = ReviewAdapter(NewArrayList)
        NewRecylerview.adapter = adapter



    }


}

