package com.example.handybook_construction_android_app.ui.orders_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook_construction_android_app.R


class CompletedFragment : Fragment() {
    lateinit var adapter: ActiveOrderAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ActiveOrderAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCompleted)
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=adapter
    }
}