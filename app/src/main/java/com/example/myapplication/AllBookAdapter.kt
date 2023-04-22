package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AllBookAdapter (private val bookList: ArrayList<HomeBook>) : RecyclerView.Adapter<AllBookAdapter.BookViewHolder>() {

    private lateinit var mListener: onItemClickListner

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.all_book_list,parent,false)
        return AllBookAdapter.BookViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = bookList[position]

//        holder.bookImage.setImageResource(R.drawable.sampleimage)
        Glide.with(holder.bookImage)
            .load(currentItem.homeBookImage)
            .into(holder.bookImage);

        holder.bookName.text = (currentItem.homeBookName)
        holder.bookAuthor.text = (currentItem.homeBookAuthor)
        holder.bookPrice.text = (currentItem.homeBookPrice)
        holder.bookRating.rating = (currentItem.homeBookRating)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class BookViewHolder(itemView: View, listener: AllBookAdapter.onItemClickListner) : RecyclerView.ViewHolder(itemView)
    {
        val bookImage : ImageView = itemView.findViewById(R.id.img_home_page_books)
        val bookName : TextView = itemView.findViewById(R.id.txt_home_book_name)
        val bookAuthor : TextView = itemView.findViewById(R.id.txt_home_page_book_author)
        val bookPrice : TextView = itemView.findViewById(R.id.txt_home_page_book_price)
        val bookRating : RatingBar = itemView.findViewById(R.id.ratingBar_home_books)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}