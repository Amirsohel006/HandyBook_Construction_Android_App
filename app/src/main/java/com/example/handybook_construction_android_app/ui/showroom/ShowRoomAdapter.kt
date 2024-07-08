package com.example.handybook_construction_android_app.ui.showroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class ShowRoomAdapter : RecyclerView.Adapter<ShowRoomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivShowRoomItemImage)
        val name: TextView = itemView.findViewById(R.id.tvShowRoomItemName)
        val favorite: ImageView = itemView.findViewById(R.id.ivShowRoomFavlorite)
        val description: TextView = itemView.findViewById(R.id.tvShowRoomItemCategory)
        val originalPrice: TextView = itemView.findViewById(R.id.tvShowRoomItemOriginalPrice)
        val currentPrice: TextView = itemView.findViewById(R.id.tvShowRoomItemCurrentPrice)
        val discount: TextView = itemView.findViewById(R.id.tvShowRoomItemDiscount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowRoomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_showroom, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowRoomAdapter.ViewHolder, position: Int) {
//Done
    }

    override fun getItemCount(): Int = 8
}