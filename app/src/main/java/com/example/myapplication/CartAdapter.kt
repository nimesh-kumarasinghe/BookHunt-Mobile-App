package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CartAdapter (private val cartList: ArrayList<Cart>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_list,parent,false)
        return CartAdapter.CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartList[position]
        holder.cartBookImage.setImageResource(currentItem.bookImage)
        holder.catBookName.text = (currentItem.bookName)
        holder.cartBookAuthor.text = (currentItem.bookAuthor)
        holder.cartBookPrice.text = (currentItem.bookPrice)
        //holder.cartBookQty.text = (currentItem.bookQty)

    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val cartBookImage : ImageView = itemView.findViewById(R.id.img_cart_book_image)
        val catBookName : TextView = itemView.findViewById(R.id.txt_cart_book_name)
        val cartBookAuthor : TextView = itemView.findViewById(R.id.txt_cart_book_author)
        val cartBookPrice : TextView = itemView.findViewById(R.id.txt_cart_book_price)
        //val cartBookQty : EditText = itemView.findViewById(R.id.txt_qty)

    }
}