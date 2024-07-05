package com.example.handybook_construction_android_app.ui.helpeaqsactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class HelpEAQsAdapter () :
    RecyclerView.Adapter<HelpEAQsAdapter.CardViewHolder>() {

    private val itemList = mutableListOf<Boolean>()

    init {
        for (i in 0 until 8) {
            itemList.add(false)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_asked_questions, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.ivHelperText.visibility = View.GONE
        holder.tvDropDown.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.drop_down_icon, 0)

        if (itemList[position]) {
            holder.ivHelperText.visibility = View.VISIBLE
            holder.tvDropDown.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up, 0)
        }

        holder.tvDropDown.setOnClickListener {
            itemList[position] = !itemList[position]
            onBindViewHolder(holder, position)
        }
    }
    override fun onViewRecycled(holder: CardViewHolder) {
        super.onViewRecycled(holder)
        holder.ivHelperText.visibility = View.GONE
        holder.tvDropDown.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.drop_down_icon, 0)
    }

    override fun getItemCount(): Int = 8

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvDropDown: TextView = itemView.findViewById(R.id.tvDropDown)
        val ivHelperText: TextView = itemView.findViewById(R.id.iv_helper_Text)

    }


}