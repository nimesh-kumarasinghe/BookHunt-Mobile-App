package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CategoryAdapter (private val categoryList: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    private lateinit var mListener: onItemClickListner

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false)
        return CategoryViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.categoryImage.setImageResource(currentItem.categoryImage)
        holder.categoryName.text = (currentItem.categoryName)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(itemView: View, listener: onItemClickListner) : RecyclerView.ViewHolder(itemView)
    {
        val categoryImage : ShapeableImageView = itemView.findViewById(R.id.img_cat_image)
        val categoryName : TextView = itemView.findViewById(R.id.txt_cat_name)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}