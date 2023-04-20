package com.example.myapplication

//import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchedBooks : AppCompatActivity() {

    private lateinit var newRecylerview : RecyclerView
    private lateinit var newArrayList: ArrayList<Books>
    lateinit var imgId : Array<Int>
    lateinit var bkname : Array<String>
    lateinit var author : Array<String>
    lateinit var price : Array<String>
    lateinit var rbar : Array<Float>
    lateinit var bookDescr : Array<String>


    //@SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searched_books)

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

        newRecylerview = findViewById(R.id.recyclerView)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Books>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in imgId.indices){
            val info = Books(imgId[i],bkname[i],author[i],price[i],rbar[i],bookDescr[i])
            newArrayList.add(info)
        }
        newRecylerview.adapter = BookAdapter(newArrayList)

    }



}