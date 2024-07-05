package com.example.handybook_construction_android_app.ui.cartactivty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class CartAdapter() :
    RecyclerView.Adapter<CartAdapter.CardViewHolder>() {
    private var quantities: MutableList<Int> = mutableListOf(1)
    init {
        // Initialize with 6 items
        for (i in 1..6) {
            quantities.add(1) // Initialize quantities with zeros
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.textView.text = quantities[position].toString()
        holder.decrementButton.setOnClickListener {
            if (quantities[position] > 0) {
                quantities[position] = quantities[position] - 1
                holder.textView.text = quantities[position].toString()
            }
        }
        holder.incrementButton.setOnClickListener {
            quantities[position] = quantities[position] + 1
            holder.textView.text = quantities[position].toString()
        }
    }

    override fun getItemCount(): Int = quantities.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val decrementButton: Button = itemView.findViewById(R.id.button_decrement)
        val incrementButton: Button = itemView.findViewById(R.id.button_increment)
        val textView: TextView = itemView.findViewById(R.id.textview_number)
    }


}