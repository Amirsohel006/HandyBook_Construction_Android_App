package com.example.handybook_construction_android_app.ui.book_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.bookstoreactivity.BookAdapter.ViewHolder

class HorizontalBookAdapter:RecyclerView.Adapter<HorizontalBookAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorizontalBookAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_details, parent, false)
        return ViewHolder(
            view
        )
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onBindViewHolder(holder: HorizontalBookAdapter.ViewHolder, position: Int) {
       holder.itemView.setOnClickListener { //Clicked
       }
    }

    override fun getItemCount(): Int {
       return 8
    }
}