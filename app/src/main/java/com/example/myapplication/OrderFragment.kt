package com.example.myapplication

import android.content.Intent
import android.os.Bundle
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

private lateinit var adapter: OrderAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var orderArrayList: ArrayList<Order>

//lateinit var orderID: Array<String>
//lateinit var orderDate: Array<String>
//lateinit var orderTotalAmount: Array<String>
//lateinit var orderStatus: Array<String>


/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        orderArrayList = arrayListOf<Order>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://api.icodingx.com/bookhunt/orders/search?CustomerID=1"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url,
            null,
            { response ->
                for (x in 0 until response.length()) {
                    val order = response.getJSONObject(0)
                    orderArrayList.add(
                        Order(
                            order.getString("OrderID"),
                            order.getString("OrderDate"),
                            order.getString("TotalAmount"),
                            order.getString("OrderStatus")
                        )
                    )
                }

                val layoutManager = LinearLayoutManager(context)
                recyclerView = view.findViewById(R.id.order_recyler_view)
                recyclerView.layoutManager = layoutManager
                recyclerView.setHasFixedSize(true)
                adapter = OrderAdapter(orderArrayList)
                recyclerView.adapter = adapter

                adapter.setOnItemClickListener(object : OrderAdapter.onItemClickListner {
                    override fun onItemClick(position: Int) {
                        var myIntent = Intent(context, OrderDetails::class.java)
                        myIntent.putExtra("order_id", orderArrayList[position.toInt()].orderNumber)
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
}