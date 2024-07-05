package com.example.handybook_construction_android_app.ui.helpeaqsactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class HelpEAQsAdapter (val listener : OnClickListener) :
    RecyclerView.Adapter<HelpEAQsAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_asked_questions, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = 8

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}