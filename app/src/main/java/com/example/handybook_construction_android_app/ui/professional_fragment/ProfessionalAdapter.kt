package com.example.handybook_construction_android_app.ui.professional_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class ProfessionalAdapter (val listener : OnClickListener) :
    RecyclerView.Adapter<ProfessionalAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_professionals, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // Bind your data here
        //holder.cardTitle.text = items[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = 8

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cardTitle: TextView = itemView.findViewById(R.id.card_title)
//        val cardTime: TextView = itemView.findViewById(R.id.card_time)
//        val cardStatus: TextView = itemView.findViewById(R.id.card_status)
    }

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}