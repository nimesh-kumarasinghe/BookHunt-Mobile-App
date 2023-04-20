package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter(private val reviewlist : ArrayList<Reviews>) : RecyclerView.Adapter<ReviewAdapter.myReviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myReviewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.review_list, parent, false )
        return myReviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myReviewHolder, position: Int) {
        val currentItem = reviewlist[position]
        holder.uname.text = currentItem.userName
        holder.bktitle.text = currentItem.booktitle
        holder.revieww.text = currentItem.bkReview
        holder.revwbar.rating = currentItem.ratingReview


    }

    override fun getItemCount(): Int {
        return reviewlist.size
    }

    class myReviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val uname: TextView = itemView.findViewById(R.id.txt_user_name)
        val bktitle: TextView = itemView.findViewById(R.id.txt_book_name)
        val revieww: TextView = itemView.findViewById(R.id.txt_review_txt)
        val revwbar: RatingBar = itemView.findViewById(R.id.ratingbar_user)


        init {
            // Set up the RatingBar
            revieww.z = 5F
            revieww.y = 1F
        }


    }


}