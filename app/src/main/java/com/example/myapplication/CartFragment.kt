package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: CartAdapter
private lateinit var recyclerView1: RecyclerView
private lateinit var cartArrayList1: ArrayList<Cart>

//lateinit var cartBookImage: Array<Int>
//lateinit var cartBookkName: Array<String>
//lateinit var cartBookAuthor: Array<String>
//lateinit var cartBookPrice: Array<String>
//lateinit var cartBookQty: Array<Editable>

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        cartArrayList1 = arrayListOf<Cart>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //dataInitialize()

        val queue = Volley.newRequestQueue(requireContext())
        val url = ""

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url,
            null,
            { response ->
                //Success

                for (x in 0 until response.length()){
                    val cate = response.getJSONObject(x)

                }
            },
            { error ->
                // Handle error
            }
        )
        queue.add(jsonArrayRequest)

//        recyclerView1 = view.findViewById(R.id.cart_recyler_view)
//        recyclerView1.layoutManager = LinearLayoutManager(context)
//        recyclerView1.setHasFixedSize(true)
//        adapter = CartAdapter(cartArrayList1)
//        recyclerView1.adapter = adapter


    }

//
//    private fun dataInitialize() {
//        cartArrayList1 = arrayListOf<Cart>()
//
//        cartBookImage = arrayOf(
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage
//        )
//
//        cartBookkName = arrayOf(
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name),
//            getString(R.string.book_name)
//        )
//
//        cartBookAuthor = arrayOf(
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name),
//            getString(R.string.author_name)
//        )
//
//        cartBookPrice = arrayOf(
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price),
//            getString(R.string.book_price)
//        )
//
//        /*cartBookQty = arrayOf(
//            getString.Editable(R.string.qty),
//
//        )*/
//
//
//        for (i in cartBookImage.indices) {
//            val cart = Cart(
//                cartBookImage[i],
//                cartBookkName[i],
//                cartBookAuthor[i],
//                cartBookPrice[i]
//            )//,cartBookQty[i] )
//            cartArrayList1.add(cart)
//        }
//
//
//    }
}