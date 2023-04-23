package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat.getFloat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

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

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

//        val txt_sh_keyword = view.findViewById<EditText>(R.id.txt_sh_keyword)
//        view.findViewById<Button>(R.id.btn_search)
        view.findViewById<ImageButton>(R.id.btn_search).setOnClickListener(){
            val queue = Volley.newRequestQueue(requireContext())
            val url = "https://api.icodingx.com/bookhunt/books/search?keyword=${view.findViewById<EditText>(R.id.txt_sh_keyword).text}"
            homeBookArrayList.clear()
            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url,
                null,
                { response ->
                    for (x in 0 until response.length()) {
                        val book = response.getJSONObject(x)
                        homeBookArrayList.add(
                            HomeBook(
                                book.getString("BookID"),
                                book.getString("imgLocation"),
                                book.getString("Title"),
                                book.getString("Author"),
                                book.getString("Price"),
                                "1.0".toFloat()
                            )
                        )
                    }
                    recyclerView.adapter = adapter
                    adapter = AllBookAdapter(homeBookArrayList)
                    adapter.notifyDataSetChanged()


                    adapter.setOnItemClickListener(object : AllBookAdapter.onItemClickListner {
                        override fun onItemClick(position: Int) {
                            var myIntent = Intent(context, BookItem::class.java)
                            myIntent.putExtra("book_id",homeBookArrayList[position.toInt()].book_id)
                            startActivity(myIntent)
                        }
                    })

                },
                { error ->
                    Log.e("response", error.toString())
                }
            )
            queue.add(jsonArrayRequest)
        }

        //btn_sh.setOnClickListener(){}

        view.findViewById<ImageButton>(R.id.btn_nearest_store).setOnClickListener() {
            var nearestShop = Intent(context, FindNearestStore::class.java)
            startActivity(nearestShop)
        }

        homeBookArrayList = arrayListOf<HomeBook>()
        offerArrayList = arrayListOf<HomeOffer>()

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

    fun setAdData(onSuccess: (x: Int) -> Unit) {
        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://api.icodingx.com/bookhunt/advertisements/"
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url,
            null,
            { response ->
                for (x in 0 until response.length()) {
                    val ad = response.getJSONObject(x)
                    offerArrayList.add(
                        HomeOffer(
                            ad.getString("PosterUrl")
                        )
                    )
                }
                onSuccess(1)
                //handel success
            },
            { error ->
                Log.e("response", error.toString())
            }
        )
        queue.add(jsonArrayRequest)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://api.icodingx.com/bookhunt/books/"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url,
            null,
            { response ->
                for (x in 0 until response.length()) {
                    val book = response.getJSONObject(x)
                    homeBookArrayList.add(
                        HomeBook(
                            book.getString("BookID"),
                            book.getString("imgLocation"),
                            book.getString("Title"),
                            book.getString("Author"),
                            book.getString("Price"),
                            "1.0".toFloat()
                        )
                    )
                }

                setAdData() { r ->

//                    Log.e("xx", homeBookArrayList.toString())
                    recyclerView = view.findViewById(R.id.all_books_recylerView)
                    recyclerView.layoutManager = GridLayoutManager(context, 3)
                    recyclerView.setHasFixedSize(true)
                    adapter = AllBookAdapter(homeBookArrayList)
                    recyclerView.adapter = adapter

                    adapter.setOnItemClickListener(object : AllBookAdapter.onItemClickListner {
                        override fun onItemClick(position: Int) {
                            var myIntent = Intent(context, BookItem::class.java)
                            myIntent.putExtra("book_id",homeBookArrayList[position.toInt()].book_id)
                            startActivity(myIntent)
                        }
                    })

                    recyclerViewOffer = view.findViewById(R.id.offer_recylerView)
                    recyclerViewOffer.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    recyclerViewOffer.setHasFixedSize(true)
                    adapterOffer = HomeOfferAdapter(offerArrayList)
                    recyclerViewOffer.adapter = adapterOffer
                }
            },
            { error ->
                Log.e("response", error.toString())
            }
        )
        queue.add(jsonArrayRequest)

    }
}