package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

  class BookAdapter(private val bookList : ArrayList<Books>) : RecyclerView.Adapter<BookAdapter.bookItemsViewHolder>() {


      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookItemsViewHolder {
          val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_list, parent, false)
          return bookItemsViewHolder(itemView)
      }

      override fun onBindViewHolder(holder: bookItemsViewHolder, position: Int) {
          val currentItem = bookList[position]
          holder.titleImg.setImageResource(currentItem.titleImage)
          holder.bkname.text = currentItem.bookName
          holder.author.text = currentItem.authorName
          holder.price.text = currentItem.bookPrice
          holder.rbar.rating = currentItem.ratingB
          holder.bookDescr.text = currentItem.bookDescription
      }

      override fun getItemCount(): Int {
          return bookList.size
      }

      class bookItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

          val titleImg: ShapeableImageView = itemView.findViewById(R.id.img_titleimg)
          val bkname: TextView = itemView.findViewById(R.id.txt_bookname_txt)
          val author: TextView = itemView.findViewById(R.id.txt_autor_text)
          val price: TextView = itemView.findViewById(R.id.txt_price_text)
          val rbar: RatingBar = itemView.findViewById(R.id.ratingbar_recy)
          val bookDescr: TextView = itemView.findViewById(R.id.txt_description_text)



          init {
              // Set up the RatingBar
              rbar.numStars = 5
              rbar.stepSize = 0.5F
          }

      }
  }






