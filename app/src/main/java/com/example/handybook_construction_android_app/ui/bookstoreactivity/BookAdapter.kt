package com.example.handybook_construction_android_app.ui.bookstoreactivity

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.cartactivty.CartAdapter.CardViewHolder

class BookAdapter:RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val bookImage:ImageView = itemview.findViewById(R.id.ivBookImage)
        val bookName:TextView = itemview.findViewById(R.id.tvBookName)
        val originalPrice:TextView = itemview.findViewById(R.id.tvOriginalPrice)
        val actualPrice:TextView = itemview.findViewById(R.id.tvCurrentPrice)
        val discount:TextView = itemview.findViewById(R.id.tvDiscount)
        val add:Button = itemview.findViewById(R.id.btAddBook)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_store, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}