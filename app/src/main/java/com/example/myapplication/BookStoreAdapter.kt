package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class BookStoreAdapter (private val storeList : ArrayList<BookStore>) : RecyclerView.Adapter<BookStoreAdapter.storeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): storeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_store_list, parent, false)
        return BookStoreAdapter.storeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: storeViewHolder, position: Int) {
        val currentItem = storeList[position]

//        holder.storeImage.setImageResource(R.drawable.user_image)
        Glide.with(holder.storeImage)
            .load(currentItem.storeImage)
            .into(holder.storeImage);
        holder.storeName.text = currentItem.storeName
        holder.storeAddress.text = currentItem.storeAddress
        holder.storeTelephone.text = currentItem.storeTelephone
        holder.storeEmail.text = currentItem.storeEmail
        holder.storeDistance.text =currentItem.storeDistance

    }

    override fun getItemCount(): Int {
        return storeList.size
    }

    class storeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val storeImage: ImageView = itemView.findViewById(R.id.img_store_image)
        val storeName: TextView = itemView.findViewById(R.id.txt_store_name)
        val storeAddress: TextView = itemView.findViewById(R.id.txt_store_address)
        val storeTelephone: TextView = itemView.findViewById(R.id.txt_store_telephone)
        val storeEmail: TextView = itemView.findViewById(R.id.txt_store_email)
        val storeDistance: TextView = itemView.findViewById(R.id.txt_distance)

    }
}