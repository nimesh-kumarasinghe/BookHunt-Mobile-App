package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.media.Rating
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: ReviewAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var reviewArrayList: ArrayList<Review>

lateinit var bookName: Array<String>
lateinit var comment: Array<String>
lateinit var rating: Array<Float>

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_profile, container, false)

        val sharedPref = requireActivity().getSharedPreferences("customer_data_sv", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)
        val customer_id = sharedPref.getString("logged", null)

        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://api.icodingx.com/bookhunt/customers/${customer_id}"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,
            null,
            { response ->
                //success
                view.findViewById<TextView>(R.id.txt_user_name).text =
                    response.getString("FirstName")
                view.findViewById<TextView>(R.id.txt_user_location).text =
                    response.getString("AddressNo")+", " + response.getString("Street")+", " + response.getString(
                        "City"
                    )
            },
            { error ->
                Log.e("response", error.toString())
            }
        )
        queue.add(jsonObjectRequest)

        /*view.findViewById<Button>(R.id.btn_edit_profile).setOnClickListener() {
            //Log.e("Data", "Edit Profile Button Clicked")
            var edit_profile = Intent(context, EditProfile::class.java)
            startActivity(edit_profile)
        }*/

        view.findViewById<Button>(R.id.btn_signout_x).setOnClickListener() {
            val sharedPref =
                requireActivity().getSharedPreferences("customer_data_sv", MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.remove("isLogin")
            editor.remove("logged")

            editor.apply()


            val alreadyAccIntent = Intent(requireActivity(), Signin::class.java)
            startActivity(alreadyAccIntent)

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //dataInitialize()
        /*val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyler_view_review_user_profile)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ReviewAdapter(reviewArrayList)
        recyclerView.adapter = adapter*/

    }

//    @RequiresApi(Build.VERSION_CODES.Q)
    //   @SuppressLint("ResourceType")
    /*   private fun dataInitialize() {
           reviewArrayList = arrayListOf<Review>()

           bookName = arrayOf(
               getString(R.string.book_name_for_review),
               getString(R.string.book_name_for_review),
               getString(R.string.book_name_for_review),
               getString(R.string.book_name_for_review),
               getString(R.string.book_name_for_review),
               getString(R.string.book_name_for_review)
           )

           comment = arrayOf(
               getString(R.string.review_comment),
               getString(R.string.review_comment),
               getString(R.string.review_comment),
               getString(R.string.review_comment),
               getString(R.string.review_comment),
               getString(R.string.review_comment)
           )

           rating = arrayOf(
               resources.getFloat(R.fraction.rating),
               resources.getFloat(R.fraction.rating),
               resources.getFloat(R.fraction.rating),
               resources.getFloat(R.fraction.rating),
               resources.getFloat(R.fraction.rating),
               resources.getFloat(R.fraction.rating)
           )

           for (i in bookName.indices) {
               val review = Review(bookName[i], comment[i], rating[i])
               reviewArrayList.add(review)
           }


       }*/
}