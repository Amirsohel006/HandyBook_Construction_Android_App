package com.example.handybook_construction_android_app.ui.address.change_address

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R

class SavedAddressAdapter(val listener: OnEditController) :
    RecyclerView.Adapter<SavedAddressAdapter.CardViewHolder>() {
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val radioButton = itemView.findViewById<RadioButton>(R.id.rbSavedAddress)
        val editIV = itemView.findViewById<ImageView>(R.id.ivEditSavedAddress)
        val destinationRelation = itemView.findViewById<TextView>(R.id.tvDestinationRelation)
        val addressUserName = itemView.findViewById<TextView>(R.id.tvNameSavedAddress)
        val address = itemView.findViewById<TextView>(R.id.tvSavedAddress)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_address, parent, false)
        return CardViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.radioButton.isChecked = false
        holder.itemView.setOnClickListener {
            holder.radioButton.isChecked = !holder.radioButton.isChecked
        }
        holder.editIV.setOnClickListener {
            listener.onEditClick()
        }
    }

    interface OnEditController {
        fun onEditClick()
    }
}