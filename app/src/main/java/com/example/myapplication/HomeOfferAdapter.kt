package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class HomeOfferAdapter (private val offerList: ArrayList<HomeOffer>) : RecyclerView.Adapter<HomeOfferAdapter.OfferViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.offers_list,parent,false)
        return OfferViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val currentItem = offerList[position]
//        holder.offerImage.setImageResource(currentItem.offerImage)

        Glide.with(holder.offerImage)
            .load(currentItem.offerImage)
            .into(holder.offerImage);
    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val offerImage : ImageView = itemView.findViewById(R.id.img_offer)

    }
}