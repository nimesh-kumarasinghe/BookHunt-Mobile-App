package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter (private val orderList: ArrayList<Order>) : RecyclerView.Adapter<OrderAdapter.OderViewHolder>() {

    private lateinit var mListener: onItemClickListner

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_list,parent,false)
        return OrderAdapter.OderViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: OderViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.oderNo.text = (currentItem.orderNumber)
        holder.orderDate.text = (currentItem.orderDate)
        holder.totalAmount.text = (currentItem.totalAmount)
        holder.status.text = (currentItem.status)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class OderViewHolder(itemView: View, listener: OrderAdapter.onItemClickListner) : RecyclerView.ViewHolder(itemView)
    {
        val oderNo : TextView = itemView.findViewById(R.id.txt_store_name)
        val orderDate : TextView = itemView.findViewById(R.id.txt_store_address)
        val totalAmount : TextView = itemView.findViewById(R.id.txt_store_telephone)
        val status : TextView = itemView.findViewById(R.id.txt_store_email)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}