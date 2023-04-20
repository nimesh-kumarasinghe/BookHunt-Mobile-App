package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter (private val reviewList: ArrayList<Review>) : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.review_list,parent,false)
        return ReviewAdapter.ReviewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val currentItem = reviewList[position]
        holder.bookName.text = (currentItem.bookName)
        holder.comment.text = (currentItem.comment)
        //holder.rating.rating = (currentItem.rating)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val bookName : TextView = itemView.findViewById(R.id.txt_cart_book_name)
        val comment : TextView = itemView.findViewById(R.id.txt_cart_book_author)
        //val rating : RatingBar = itemView.findViewById(R.id.rating_display)
    }
}