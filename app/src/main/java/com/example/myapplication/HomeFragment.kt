package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat.getFloat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: AllBookAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var homeBookArrayList: ArrayList<HomeBook>

private lateinit var adapterOffer: HomeOfferAdapter
private lateinit var recyclerViewOffer: RecyclerView
private lateinit var offerArrayList: ArrayList<HomeOffer>


lateinit var offerImage : Array<Int>


lateinit var homeBookImage : Array<Int>
lateinit var homeBookName : Array<String>
lateinit var homeBookAuthor : Array<String>
lateinit var homeBookPrice : Array<String>
lateinit var homeBookRating : Array<Float>



/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<ImageButton>(R.id.btn_nearest_store).setOnClickListener() {
            var nearestShop = Intent(context, FindNearestStore::class.java)
            startActivity(nearestShop)
        }

        dataInitialize()
        setDataAllBook()

        //*****For Shop Offers Recycler View

        //val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.all_books_recylerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        //recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(true)
        adapter= AllBookAdapter(homeBookArrayList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : AllBookAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                var myIntent = Intent(context, BookItem::class.java)

                startActivity(myIntent)
            }

        })


        //val layoutManager = LinearLayoutManager(context)
        recyclerViewOffer = view.findViewById(R.id.offer_recylerView)
        recyclerViewOffer.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewOffer.setHasFixedSize(true)
        adapterOffer= HomeOfferAdapter(offerArrayList)
        recyclerViewOffer.adapter = adapterOffer


        //*****For AllBook Recycler View

        /*recyclerViewAllBook = view.findViewById(R.id.all_books_recylerView)
        recyclerViewAllBook.layoutManager = GridLayoutManager(context, 2)
        recyclerViewAllBook.setHasFixedSize(true)
        adapterAllBook = AllBookAdapter(homeBookArrayList)
        recyclerViewAllBook.adapter = adapterAllBook*/

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        //@JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    //@RequiresApi(Build.VERSION_CODES.Q)
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }*/

    //@SuppressLint("ResourceType")
    //@RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun setDataAllBook() {
        homeBookArrayList = arrayListOf<HomeBook>()

        homeBookImage = arrayOf(
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage,
            R.drawable.sampleimage
        )
        homeBookName = arrayOf(
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name),
            getString(R.string.book_name)
        )
        homeBookAuthor = arrayOf(
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name),
            getString(R.string.author_name)
        )
        homeBookPrice = arrayOf(
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price),
            getString(R.string.book_price)
        )
        homeBookRating = arrayOf(
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating),
            resources.getFloat(R.fraction.rating)
        )
        for (i in homeBookImage.indices) {
            val allBook = HomeBook(homeBookImage[i], homeBookName[i],homeBookAuthor[i],homeBookPrice[i] ,homeBookRating[i])
            homeBookArrayList.add(allBook)
        }

    }



    private fun dataInitialize() {
        offerArrayList = arrayListOf<HomeOffer>()

        offerImage = arrayOf(
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads,
            R.drawable.ads

        )
        for (i in offerImage.indices) {
            val offer = HomeOffer(offerImage[i])
            offerArrayList.add(offer)
        }


    }
}