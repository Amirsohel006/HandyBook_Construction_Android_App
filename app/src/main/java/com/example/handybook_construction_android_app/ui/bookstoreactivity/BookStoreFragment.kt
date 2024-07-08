package com.example.handybook_construction_android_app.ui.bookstoreactivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R
import com.example.handybook_construction_android_app.ui.book_details.BookDetailsActivity
import com.example.handybook_construction_android_app.ui.bookstoreactivity.BookAdapter.OnItemViewClickListener


class BookStoreFragment : Fragment(), OnItemViewClickListener {
    lateinit var adapter: BookAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvBookList)
        adapter = BookAdapter(this)
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
       startActivity(Intent(requireActivity(),BookDetailsActivity::class.java))
    }


}