package com.example.handybook_construction_android_app.ui.addressactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.cartactivty.CartAdapter.CardViewHolder

class SavedAddressAdapter : RecyclerView.Adapter<SavedAddressAdapter.CardViewHolder>() {
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
    ): SavedAddressAdapter.CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_address, parent, false)
        return SavedAddressAdapter.CardViewHolder(
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
            Log.d("Clicked","Edit")
            // Navigate to edit address activity
        }
    }
}