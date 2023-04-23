package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: CategoryAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var categoryArrayList: ArrayList<Category>

//lateinit var categoryImgId: Array<Int>
//lateinit var catName: Array<String>

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        categoryArrayList = arrayListOf<Category>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
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
        val url = "https://api.icodingx.com/bookhunt/categories/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url,
            null,
            { response ->
                //Success

                for (x in 0 until response.length()) {
                    val cate = response.getJSONObject(x)
                    categoryArrayList.add(
                        Category(
                            cate.getString("CategoryID"),
                            cate.getString("Picture"),
                            cate.getString("CategoryName")
                        )
                    )
                }

                val layoutManager = LinearLayoutManager(context)
                recyclerView = view.findViewById(R.id.category_recyclerview)
                recyclerView.layoutManager = GridLayoutManager(context, 2)
                recyclerView.setHasFixedSize(true)
                adapter = CategoryAdapter(categoryArrayList)
                recyclerView.adapter = adapter

                adapter.setOnItemClickListener(object : CategoryAdapter.onItemClickListner {
                    override fun onItemClick(position: Int) {
                        var myIntent = Intent(context, BookItemsList::class.java)
                        myIntent.putExtra("cate_id", categoryArrayList[position.toInt()].cateid)
                        startActivity(myIntent)
                    }

                })
            },
            { error ->
                // Handle error
            }
        )
        queue.add(jsonArrayRequest)


    }


//    private fun dataInitialize() {
//        categoryArrayList = arrayListOf<Category>()
//
//        categoryImgId = arrayOf(
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage,
//            R.drawable.sampleimage
//
//        )
//
//        catName = arrayOf(
//            getString(R.string.cat_name),
//
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name),
//            getString(R.string.cat_name)
//
//
//        )
//
//
//        for (i in categoryImgId.indices) {
//            val category = Category(categoryImgId[i], catName[i])
//            categoryArrayList.add(category)
//        }
//
//
//    }
}